package com.example.kotlinhelloworld.repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DbOpenHelper", " DbOpenHelper : Table created successfully");
        db.execSQL(createUserTableQuery());
        db.execSQL(createAddressTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
        }
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private static String createUserTableQuery() {
        return "CREATE TABLE " + UserTableMeta.TABLE + "("
                + UserTableMeta.COLUMN_ID + " TEXT, "
                + UserTableMeta.COLUMN_FIRST_NAME + " TEXT, "
                + UserTableMeta.COLUMN_LAST_NAME + " TEXT, "
                + UserTableMeta.COLUMN_GENDER + " TEXT, "
                + UserTableMeta.COLUMN_IS_MARRIED + " INTEGER);";
    }

    private static String createAddressTableQuery() {
        return "CREATE TABLE " + AddressTableMeta.TABLE + "("
                + AddressTableMeta.COLUMN_ID + " TEXT, "
                + AddressTableMeta.COLUMN_HOUSE_NO + " INTEGER, "
                + AddressTableMeta.COLUMN_STREET + " TEXT, "
                + AddressTableMeta.COLUMN_STATE + " TEXT, "
                + AddressTableMeta.COLUMN_CITY + " TEXT);";
    }


}
