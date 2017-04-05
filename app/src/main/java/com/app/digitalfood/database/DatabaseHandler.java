package com.app.digitalfood.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by beyond on 24-Feb-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "app_database";
    private static final String TABLE_USER_INFO = "user_info";
    private static final String KEY_ID = "id";
    private static final String USER_NAME = "user";
    private static final String USER_EMAIL = "email";
    private static final String USER_ADDRESS = "address";
    private static final String USER_CITY = "city";
    private static final String USER_PHONE = "phone";
    private static final String USER_PASSWORD = "password";
    private static final String IS_LOGGED_IN = "is_logged_in";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USER_INFO + "(" + KEY_ID + " INTEGER," + USER_NAME + " TEXT,"
                + USER_EMAIL + " TEXT, " +
                USER_ADDRESS + " TEXT, " +
                USER_CITY + " TEXT, " +
                USER_PHONE + " TEXT, " +
                USER_PASSWORD + " TEXT, " +
                IS_LOGGED_IN + " BOOLEAN)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INFO);
        // Create tables again
        onCreate(db);
    }

    public void addUserInfo(int id, String name, String email, String phone_number, boolean isLoggedIn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(USER_NAME, name);
        values.put(IS_LOGGED_IN, isLoggedIn);
        values.put(USER_EMAIL,email);
        values.put(USER_PHONE,phone_number);
        db.insert(TABLE_USER_INFO, null, values);
        Log.d("DATA TABLE", "Inserted");
        db.close();
    }

    public int getUserId() {
        SQLiteDatabase db = this.getReadableDatabase();
        String userInfo = "SELECT " + KEY_ID + " FROM " + TABLE_USER_INFO;
        Cursor cursor = db.rawQuery(userInfo, null);
        cursor.moveToFirst();
        Integer id = Integer.parseInt(cursor.getString(1));
        return id;
    }

    public boolean getUserLoginInfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String userInfo = "SELECT * FROM " + TABLE_USER_INFO;
        Cursor cursor = db.rawQuery(userInfo, null);
        cursor.moveToFirst();
        boolean isLogged = Boolean.parseBoolean(cursor.getString(3));
        Log.d("isLogged", String.valueOf(isLogged));
        return isLogged;
    }
}
