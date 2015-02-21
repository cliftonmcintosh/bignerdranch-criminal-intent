package com.cliftonmcintosh.criminalintent.app;

import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.TABLE_NAME;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry._ID;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.COLUMN_TITLE;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.COLUMN_DESCRIPTION;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.COLUMN_EXTERNAL_ID;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.COLUMN_DATE_TIME;
import static com.cliftonmcintosh.criminalintent.database.CrimeContract.CrimeEntry.COLUMN_SOLVED;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cliftonmcintosh.criminalintent.Crime;
import com.cliftonmcintosh.criminalintent.database.CrimeDatabaseHelper;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;

/**
 * Created by cmcintosh on 2/3/15.
 */
public class CrimeLab {
    public static final String ID_SELECTION = _ID + "=?";
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private CrimeDatabaseHelper mDatabaseHelper;
    private static final String[] PROJECTION = new String[]{
            _ID,
            COLUMN_EXTERNAL_ID,
            COLUMN_TITLE,
            COLUMN_DESCRIPTION,
            COLUMN_DATE_TIME,
            COLUMN_SOLVED
    };

    private CrimeLab(Context context) {
        mAppContext = context;
        mDatabaseHelper = new CrimeDatabaseHelper(context.getApplicationContext());
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime saveCrime(Crime crime) {
        Crime savedCrime;
        if (crime.getId() > 0) {
            savedCrime = update(crime);
        } else {
            savedCrime = insert(crime);
        }
        return savedCrime;
    }

    public ArrayList<Crime> getCrimes() {
        ArrayList<Crime> crimes = new ArrayList<>();
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query(true,
                TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                COLUMN_DATE_TIME + " DESC",
                null);
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                crimes.add(createCrimeFromRow(cursor));
            } while (cursor.moveToNext());
        }
        return crimes;
    }

    public Crime getCrime(Long id) {
        Crime crime = null;

        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query(true,
                TABLE_NAME,
                PROJECTION,
                _ID + "=?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor != null) {
            cursor.moveToFirst();
            crime = createCrimeFromRow(cursor);
        }

        return crime;
    }

    private Crime insert(Crime crime) {

        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues values = createContentValuesFromCrime(crime);
        Long rowId = db.insert(TABLE_NAME, null, values);
        return getCrimeById(rowId);
    }

    public Crime update(Crime crime) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        ContentValues values = createContentValuesFromCrime(crime);
        db.update(TABLE_NAME, values, ID_SELECTION, new String[]{String.valueOf(crime.getId())});

        return crime;
    }

    private ContentValues createContentValuesFromCrime(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, crime.getTitle());
        values.put(COLUMN_DESCRIPTION, crime.getDescription());
        values.put(COLUMN_EXTERNAL_ID, crime.getExternalId());
        values.put(COLUMN_DATE_TIME, crime.getDateTime().toDateTime().getMillis());
        values.put(COLUMN_SOLVED, crime.isSolved());
        return values;
    }

    private Crime getCrimeById(Long id) {
        Crime crime = null;

        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query(true,
                TABLE_NAME,
                PROJECTION,
                ID_SELECTION,
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            crime = createCrimeFromRow(cursor);
        }
        return crime;
    }

    /**
     * @param cursor cannot be null
     * @return a Crime
     */
    private Crime createCrimeFromRow(Cursor cursor) {
        return new Crime(
                Long.valueOf(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                new LocalDateTime(Long.valueOf(cursor.getString(4))),
                (cursor.getInt(5) > 0)
        );
    }
}
