package com.abbi.practics1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelpeer extends SQLiteOpenHelper {
public static final String DATABASE_NAME = "classwork.db";
public static final int DATABASE_VERSION = 1;


    public DatabaseHelpeer(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Table.TABLE_NAME + " (" +
                    Table._ID + " INTEGER PRIMARY KEY," +
                    Table.COLUMN_FIRSTNAME + "TEXT," +
                    Table.COLUMN_LASTNAME + "TEXT," +
                    Table.COLUMN_EMAIL + "TEXT," +
                    Table.COLUMN_PASSWORD + "TEXT," +
                    Table.COLUMN_ADDRESS + "TEXT," +
                    Table.COLUMN_PHONENUMBER + " TEXT)" ;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS" + Table.TABLE_NAME;
}
