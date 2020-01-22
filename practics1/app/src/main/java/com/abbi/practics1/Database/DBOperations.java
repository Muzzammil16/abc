package com.abbi.practics1.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.abbi.practics1.ApplicationContext;

public class DBOperations {

    DatabaseHelpeer db;

    public DBOperations() {
        db = new DatabaseHelpeer(ApplicationContext.getAppContext());
    }

    public long writeUserinDB (Properties pro)
    {

        long isSuccessful =0;
        ContentValues value = new ContentValues();
        value.put(Table.COLUMN_FIRSTNAME,pro.getFirstName());
        value.put(Table.COLUMN_LASTNAME,pro.getLastName());
        value.put(Table.COLUMN_EMAIL,pro.getEmail());
        value.put(Table.COLUMN_PASSWORD,pro.getPassword());
        value.put(Table.COLUMN_ADDRESS,pro.getAddress());
        value.put(Table.COLUMN_PHONENUMBER,pro.getPhonenumber());

        isSuccessful = getWritableSqlDb().insert(Table.TABLE_NAME,null,value);
        return isSuccessful;
    }
    public SQLiteDatabase getWritableSqlDb() {
        return  db.getWritableDatabase();
    }

    public SQLiteDatabase getReadableSqlDb() {
        return db.getReadableDatabase();
    }


    public Properties getPropertiesInformation(String email)
    {
        Properties mytab = new Properties();
        String[] projection ={
                Table._ID,
                Table.COLUMN_FIRSTNAME,
                Table.COLUMN_LASTNAME,
                Table.COLUMN_EMAIL,
                Table.COLUMN_PASSWORD,
                Table.COLUMN_ADDRESS,
                Table.COLUMN_PHONENUMBER
        };
        String selection = Table.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = getReadableSqlDb().query(
                Table.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

    while(cursor.moveToNext())
    {
     mytab.setAddress(cursor.getString(
             cursor.getColumnIndexOrThrow(Table.COLUMN_ADDRESS)));
        mytab.setEmail(cursor.getString(
                cursor.getColumnIndexOrThrow(Table.COLUMN_EMAIL)));
        mytab.setFirstName(cursor.getString(
                cursor.getColumnIndexOrThrow(Table.COLUMN_FIRSTNAME)));
    }
    return mytab;

    }
}
