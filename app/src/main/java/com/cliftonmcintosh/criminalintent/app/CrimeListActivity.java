package com.cliftonmcintosh.criminalintent.app;

import android.app.Fragment;
import android.net.Uri;

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.OnFragmentInteractionListener {
    @Override
    protected Fragment createFragment() {
        return CrimeListFragment.newInstance();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // do nothing
    }
}
