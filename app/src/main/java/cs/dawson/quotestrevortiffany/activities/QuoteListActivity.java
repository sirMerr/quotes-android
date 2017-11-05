package cs.dawson.quotestrevortiffany.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cs.dawson.quotestrevortiffany.R;
import cs.dawson.quotestrevortiffany.entities.Category;
import cs.dawson.quotestrevortiffany.entities.Quote;

/**
 * Quotes List Activity. Will show a ListView
 * and display the short quote for all quotes in that category.
 * When a user clicks on the short quote launch QuoteActivity
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class QuoteListActivity extends MenuActivity {
    static final String TAG = "QuotesListActivity: ";
    private ArrayAdapter<String> adapterString;
    private ListView lv;
    private Context context;
    private int categoryId;

    /**
     * When invoked, will set up the activity.
     * Gets the intent and category index, sets the list view and
     * set short quotes based on those
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);
        context = this.getApplicationContext();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        categoryId = extras.getInt("categoryId");

        lv = (ListView) findViewById(R.id.listView2);

        setListView();
        setShortQuotes();
    }

    /**
     * Set the ListView with our short quotes
     */
    private void setListView() {
        Log.d(TAG, "Setting list view");
        Log.d(TAG, "Categories: " + categories);

        adapterString = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shortQuotes);
        lv.setAdapter(adapterString);

        // Click listeners on items that pass the category and quote index
        // to QuoteActivity
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, QuoteActivity.class);
                i.putExtra("quoteId", position);
                i.putExtra("categoryId", categoryId);
                startActivity(i);
            }
        });

    }

    /**
     * Sets the short quotes from the index passed through the extras
     */
    private void setShortQuotes() {
        if (categories != null && !categories.isEmpty()) {
            // Get category clicked by user
            Category category = categories.get(categoryId);

            // Get quotes in the category
            List<Quote> quotes = category.getQuotes();

            // Add short quotes to list
            for (int i = 0; i < quotes.size(); i++) {
                shortQuotes.add(quotes.get(i).getShortQuote());
            }

            adapterString.notifyDataSetChanged();
        }
    }
}
