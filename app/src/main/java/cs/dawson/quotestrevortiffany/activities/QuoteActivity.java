package cs.dawson.quotestrevortiffany.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cs.dawson.quotestrevortiffany.R;
import cs.dawson.quotestrevortiffany.entities.Quote;

/**
 * Quote Activity displays all of the information associated with the quote,
 * except the blurb. Include the image for the category. The URI is be clickable,
 * named reference. The name attributed is clickable and will show a dialogue containing
 * the blurb information with one button to dismiss.
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class QuoteActivity extends MenuActivity {
    static final String TAG = "QuoteActivity Class: ";
    private Quote quote = new Quote();
    private TextView tvName, tvBirthdate, tvDateAdded,
            tvFullQuote, tvShortQuote, tvUrl;
    private ImageView imageView;
    private String categoryImage;

    /**
     * When invoked, will set up the activity.
     * Assigns the text views and image views,
     * gets the intent and category index and quote index,
     * sets the list view and set Quote information
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        setContentView(R.layout.activity_quote);

        tvName = (TextView) findViewById(R.id.textViewName);
        tvBirthdate = (TextView) findViewById(R.id.textViewBirthdate);
        tvDateAdded = (TextView) findViewById(R.id.textViewDateAdded);
        tvFullQuote = (TextView) findViewById(R.id.textViewFullQuote);
        tvShortQuote = (TextView) findViewById(R.id.textViewShortQuote);
        tvUrl = (TextView) findViewById(R.id.textViewUrl);
        imageView = (ImageView) findViewById(R.id.imageView2);

        // User chose it
        if (savedInstanceState == null) {
            int categoryId = extras.getInt("categoryId");
            int quoteId = extras.getInt("quoteId");
            Log.d(TAG, "User chose quote id: "  + quoteId);

            quote = categories.get(categoryId).getQuotes().get(quoteId);

            Log.d(TAG,"Image: " + categories.get(categoryId).getImage());
            categoryImage = categories.get(categoryId).getImage();
            setView();
        }

        if(extras.getBoolean("last")  == true)
            loadLast();
    }

    /**
     * Set the view with the data from the quotes
     */
    private void setView() {
        tvName.setText(quote.getAuthor().getName());
        tvBirthdate.setText(quote.getAuthor().getBirthdate());
        tvDateAdded.setText(quote.getDateAdded());
        tvFullQuote.setText(quote.getFullQuote());
        tvShortQuote.setText(quote.getShortQuote());
        tvUrl.setText(quote.getUrl());

        Glide.with(this /* context */)
                .load(categoryImage)
                .into(imageView);
    }

    /**
     * Shows alert with blurb
     * @param v
     */
    public void displayBlurb(View v) {
        new AlertDialog.Builder(this)
                .setMessage(quote.getAuthor().getBlurb())
                .setPositiveButton("Ok \uD83D\uDC27", null)
                .show();
    }

    /**
     * Overridden onPause so that last Quote is saved
     */
    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("tvName", tvName.getText().toString());
        editor.putString("birth", tvBirthdate.getText().toString());
        editor.putString("date", tvDateAdded.getText().toString());
        editor.putString("fullQuote", tvFullQuote.getText().toString());
        editor.putString("shortQuote", tvShortQuote.getText().toString());
        editor.putString("tv", tvUrl.getText().toString());
        editor.putString("category", categoryImage);

        editor.commit();
    }

    /**
     * Loads last shown quote from shared preferences
     */
    public void loadLast() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        tvName.setText(prefs.getString("tvName", ""));
        tvBirthdate.setText(prefs.getString("birth", ""));
        tvDateAdded.setText(prefs.getString("date", ""));
        tvFullQuote.setText(prefs.getString("fullQuote", ""));
        tvShortQuote.setText(prefs.getString("shortQuote", ""));
        tvUrl.setText(prefs.getString("tv",""));
        categoryImage = prefs.getString("category", "");
        Glide.with(this)
                .load(categoryImage)
                .into(imageView);
    }
}
