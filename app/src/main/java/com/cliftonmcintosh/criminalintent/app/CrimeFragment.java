package com.cliftonmcintosh.criminalintent.app;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.cliftonmcintosh.criminalintent.Crime;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link CrimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeFragment extends Fragment {
    public static final String EXTRA_CRIME_ID = "com.cliftonmcintosh.criminalintent.app.crime_id";

    private static final String TAG = "CrimeFragment";

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateTimeButton;
    private CheckBox mSolvedCheckBox;
    private CrimeLab mCrimeLab;

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @param crimeId the id of the crime for this fragment
     * @return A new instance of fragment CrimeFragment.
     */
    public static CrimeFragment newInstance(Long crimeId) {
        CrimeFragment fragment = new CrimeFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        fragment.setArguments(args);
        return fragment;
    }

    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Long crimeId = (Long) getArguments().getSerializable(EXTRA_CRIME_ID);

        mCrimeLab = CrimeLab.get(getActivity().getApplicationContext());
        mCrime = mCrimeLab.getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitleField = (EditText) view.findViewById(R.id.crime_title);
        String title = mCrime.getTitle();
        if (title != null) {
            mTitleField.setText(title);
        }
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mCrime = mCrimeLab.saveCrime(mCrime);
            }
        });

        mDateTimeButton = (Button) view.findViewById(R.id.crime_date);
        mDateTimeButton.setText(mCrime.getDateTime().toString("EEEE, MMMM dd, YYYY"));
        mDateTimeButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) view.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
                mCrime = mCrimeLab.saveCrime(mCrime);
            }
        });
        return view;
    }

}
