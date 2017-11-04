package cs.dawson.quotestrevortiffany.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;

import cs.dawson.quotestrevortiffany.R;
import cs.dawson.quotestrevortiffany.entities.Category;

/**
 * Main Activity that gets the data from our
 * firebase database and has the first list
 * of all categories.
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class MainActivity extends MenuActivity {
    static final String TAG = "MainActivity Class: ";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String email = "letiffany.nguyen@gmail.com";
    private String password = "adminquotes";
    private ListView lv;
    private Context context;
    private ArrayAdapter<String> adapterString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();

        lv = (ListView) findViewById(R.id.listView);

        authFirebase();
        getDB();

        setListView();
    }

    private void authFirebase() {
        // Initiate FirebaseAuth and AUthStateListener to track
        // whenever user signs in or out
        mAuth = FirebaseAuth.getInstance();
        signIn(email, password);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }
    private void setListView() {
        Log.d(TAG, "Setting list view");
        Log.d(TAG, "Categories: " + categories);

        adapterString = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        lv.setAdapter(adapterString);

        // Click listeners for items
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = ((TextView) view).getText().toString();
                Log.i(TAG, "onItemClick - category:" + category);
                Log.i(TAG, "onItemClick - position:" + position);

                Intent i = new Intent(context, QuoteListActivity.class);
                i.putExtra(QuoteListActivity.CATEGORY, position);
                startActivity(i);
            }
        });

    }

    /**
     * Attach listener to FirebaseAuth
     */
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    /**
     * Attach listener to FirebaseAuth
     */
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /**
     * Signs into firebase with email and password
     * @param email
     * @param password
     */
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Initiate Database Realtime with Firebase and
     * add event listeners to listen for data changes
     */
    private void getDB() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("categories");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "Snapshot: " + dataSnapshot);

                for (DataSnapshot categorySnap: dataSnapshot.getChildren()) {
                    categories.add(categorySnap.getValue(Category.class));
                }

                for (int i = 0; i < categories.size(); i++) {
                    titles.add(categories.get(i).getTitle());
                }
                adapterString.notifyDataSetChanged();
                Log.d(TAG, "Categories found: " + categories);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    /**
     * Return a drawable to display from an image
     * url. You can then set the image to an image view
     * @param url
     *      from Firebase
     * @return Drawable
     */
    public Drawable getImageFromUrl(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            return Drawable.createFromStream(is, "url");
        } catch (Exception e) {
            return null;
        }
    }
}
