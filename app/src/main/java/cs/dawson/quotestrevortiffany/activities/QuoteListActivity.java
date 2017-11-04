package cs.dawson.quotestrevortiffany.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.Random;

import cs.dawson.myapplication.R;

/**
 * Quotes List Activity. Will show a ListView
 * and display the short quote for all quotes in that category.
 * When a user clicks on the short quote launch QuoteActivity
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class QuoteListActivity extends MenuActivity {
    private List<String> shortQuotes;
    public static final String CATEGORY = "trevortiffany.category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_page);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // TODO: read from save state to get which category to display
    }
}
