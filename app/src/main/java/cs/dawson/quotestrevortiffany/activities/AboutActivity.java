package cs.dawson.quotestrevortiffany.activities;

import android.os.Bundle;

import cs.dawson.quotestrevortiffany.R;

/**
 * About activity containing information about
 * the project and an image
 *
 * @author Trevor Eames
 * @author Tiffany Le-Nguyen
 */
public class AboutActivity extends MenuActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
    }
}
