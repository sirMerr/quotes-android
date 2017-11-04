package cs.dawson.quotestrevortiffany.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import cs.dawson.myapplication.R;

/**
 * Created by sirMerr on 2017-11-04.
 */

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";
    protected DatabaseReference mDatabase;
    protected FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * Invoked when user selects a menu item and
     * shows the selected intent
     *
     * @param item
     * @return true if passed
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.aboutItem:
                displayAbout();
                return true;
            case R.id.randomItem:
                displayRandom();
                return true;
            case R.id.lastItem:
                displayLastRun();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Display about activity
     */
    private void displayAbout() {
        Log.i(TAG, "Displaying About");
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Display random quote
     */
    private void displayRandom() {
        Log.i(TAG, "Displaying Random");
        Intent intent = new Intent(this, QuoteActivity.class);

        // TODO: Choose random category and put extra

        startActivity(intent);
    }

    /**
     * Display last saved quote from shared prefs
     */
    private void displayLastRun() {
        Log.i(TAG, "Displaying Last Run");
        Intent intent = new Intent(this, QuoteActivity.class);
        startActivity(intent);
    }
}
