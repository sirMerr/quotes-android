package cs.dawson.quotestrevortiffany.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import cs.dawson.quotestrevortiffany.R;
import cs.dawson.quotestrevortiffany.entities.Category;

/**
 * Menu Activity which has the about, random and last
 * run items that each other activity will implement
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";
    protected List<String> titles = new ArrayList<>();
    protected static List<Category> categories = new ArrayList<>();
    protected List<String> shortQuotes = new ArrayList<>();

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
     * This hook is called whenever an item in your options menu is selected.
     * Overrides this to include the custom menu
     *
     * @param menu
     * @return true if successful
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate((int)R.layout.menu, menu);
        return true;
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

        int randomCat = (int)Math.random() * categories.size();
        int randomQuote = (int) Math.random() * categories.get(randomCat).getQuotes().size();

        intent.putExtra("quoteId", randomQuote);
        intent.putExtra("categoryId", randomCat);

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
