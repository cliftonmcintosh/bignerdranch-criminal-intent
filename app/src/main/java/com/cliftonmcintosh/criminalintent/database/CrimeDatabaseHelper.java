package com.cliftonmcintosh.criminalintent.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cmcintosh on 2/1/15.
 */
public class CrimeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "crime.sqlite";
    private static final int VERSION = 2;

    private Context mContext;

    public CrimeDatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CrimeContract.CREATE_CRIME_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
