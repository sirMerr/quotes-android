package cs.dawson.quotestrevortiffany.activities;

import android.os.Bundle;

import cs.dawson.quotestrevortiffany.R;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_page);

    }

    /** TODO: Add blurb pop up with dismiss button **/
    /** TODO: Add save to shared preferences **/
}
