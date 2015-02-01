package com.cliftonmcintosh.criminalintent.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class CrimeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        Toolbar toolbar = (Toolbar) findViewById(R.id.crime_toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment crimeFragment = fragmentManager.findFragmentById(R.id.crime_fragment_container);
        if (crimeFragment == null) {
            crimeFragment = CrimeFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.crime_fragment_container, crimeFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crime, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
