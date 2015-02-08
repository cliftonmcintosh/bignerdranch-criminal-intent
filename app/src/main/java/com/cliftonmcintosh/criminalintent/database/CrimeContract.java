package com.cliftonmcintosh.criminalintent.database;

import android.provider.BaseColumns;

/**
 * Created by cmcintosh on 2/5/15.
 */
public class CrimeContract {
    
    public CrimeContract() {
        
    }

    public static final String CREATE_CRIME_TABLE_SQL = "CREATE TABLE " + CrimeEntry.TABLE_NAME +
            "(" +
            CrimeEntry._ID + " integer primary key autoincrement, " +
            CrimeEntry.COLUMN_EXTERNAL_ID + " varchar(64)," +
            CrimeEntry.COLUMN_TITLE + " varchar(64)," +
            CrimeEntry.COLUMN_DESCRIPTION + " varchar(256)," +
            CrimeEntry.COLUMN_DATE_TIME + " integer," +
            CrimeEntry.COLUMN_SOLVED + " boolean" +
            ")";
    
    public static abstract class CrimeEntry implements BaseColumns {
        public static final String TABLE_NAME = "crime";
        public static final String COLUMN_EXTERNAL_ID = "external_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DATE_TIME = "date_time";
        public static final String COLUMN_SOLVED = "solved";
    }
}
