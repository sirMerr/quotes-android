package cs.dawson.quotestrevortiffany.activities;

import android.content.Intent;
import android.os.Bundle;

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
    private Quote quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        setContentView(R.layout.activity_quote);



    }

    /** TODO: Add blurb pop up with dismiss button **/
    /** TODO: Add save to shared preferences **/
}
