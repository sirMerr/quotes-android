package cs.dawson.quotestrevortiffany.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
    TextView tvName, tvBirthdate, tvDateAdded,
            tvFullQuote, tvShortQuote, tvUrl;

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

        // User chose it
        if (savedInstanceState == null) {
            int categoryId = extras.getInt("categoryId");
            int quoteId = extras.getInt("quoteId");

            quote = categories.get(categoryId).getQuotes().get(quoteId);
        }

    }

    /** TODO: Add blurb pop up with dismiss button **/
    /** TODO: Add save to shared preferences **/
}
