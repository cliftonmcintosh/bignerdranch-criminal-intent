package com.cliftonmcintosh.criminalintent.app;

import android.app.Fragment;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CrimeFragment.newInstance();
    }
}
