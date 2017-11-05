package cs.dawson.quotestrevortiffany.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    ListView lv;
    private Context context;
    private int categoryId;

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

    private void setListView() {
        Log.d(TAG, "Setting list view");
        Log.d(TAG, "Categories: " + categories);

        adapterString = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shortQuotes);
        lv.setAdapter(adapterString);

        //Click listeners for the items.
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
     * Sets the short quotes from the id passed through the extras
     */
    private void setShortQuotes() {
        if (categories != null && !categories.isEmpty()) {
            Category category = categories.get(categoryId);

            List<Quote> quotes = category.getQuotes();
            for (int i = 0; i < quotes.size(); i++) {
                shortQuotes.add(quotes.get(i).getShortQuote());
            }

            adapterString.notifyDataSetChanged();
        }
    }
}
