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

import cs.dawson.quotestrevortiffany.R;

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
    public static final String CATEGORY = "trevortiffany.category";
    private ArrayAdapter<String> adapterString;
    ListView lv;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);
        context = this.getApplicationContext();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Log.d(TAG, "Extras: " + extras);

        lv = (ListView) findViewById(R.id.listView2);

        // TODO: read from save state to get which category to display
    }

    private void setListView() {
        Log.d(TAG, "Setting list view");
        Log.d(TAG, "Categories: " + categories);

        adapterString = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        lv.setAdapter(adapterString);

        //Click listeners for the items.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = ((TextView) view).getText().toString();
                Log.i(TAG, "onItemClick - category:" + category);

                Intent i = new Intent(context, QuoteListActivity.class);
                i.putExtra(QuoteListActivity.CATEGORY, category);
                startActivity(i);
            }
        });

    }
}
