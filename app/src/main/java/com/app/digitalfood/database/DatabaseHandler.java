package com.app.digitalfood.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.digitalfood.DataObject.ItemData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 24-Feb-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static DatabaseHandler databaseHandler;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "app_database";
    private static final String TABLE_USER_INFO = "user_info";
    private static final String TABLE_CART_ITEM = "cart_item";
    private static final String KEY_ID = "id";
    private static final String BRANCH_ID="branch_id";
    private static final String USER_NAME = "user";
    private static final String USER_EMAIL = "email";
    private static final String USER_ADDRESS = "address";
    private static final String USER_CITY = "city";
    private static final String USER_PHONE = "phone";
    private static final String USER_PASSWORD = "password";
    private static final String ITEM_NAME = "item_name";
    private static final String IS_LOGGED_IN = "is_logged_in";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHandler getInstance(Context context) {
        if (databaseHandler == null) {
            databaseHandler = new DatabaseHandler(context);
        }
        return databaseHandler;
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
        createTableForCartItem(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INFO);
        // Create tables again
        onCreate(db);
    }

    public void createTableForCartItem(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_CART_ITEM + "(" + KEY_ID + " INTEGER," + BRANCH_ID + " INTEGER," + ITEM_NAME + " TEXT)";
        db.execSQL(createTable);

    }

    public int getItemCount(String branch_id) {
        String countQuery = "SELECT  * FROM " + TABLE_CART_ITEM+" WHERE "+BRANCH_ID+"="+branch_id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt=0;
        cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public List<ItemData> getAllItem(String branch_id) {
        String countQuery = "SELECT  * FROM " + TABLE_CART_ITEM+" WHERE "+BRANCH_ID+"="+branch_id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        List<ItemData> list = new ArrayList<>();
        Gson gson = new Gson();
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
                ItemData subCategoryData = gson.fromJson(data, ItemData.class);
                list.add(subCategoryData);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public ItemData getItem(String branch_id, int key_id) {
        String countQuery = "SELECT  * FROM " + TABLE_CART_ITEM+" WHERE "+BRANCH_ID+"="+branch_id+" AND "+KEY_ID+" = "+key_id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        ItemData list = new ItemData();
        Gson gson = new Gson();
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
                list= gson.fromJson(data, ItemData.class);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public void addItem(ItemData item,String branch_id) {
        Gson gson=new Gson();
        String toDB=gson.toJson(item,ItemData.class);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, item.getId());
        values.put(BRANCH_ID,branch_id);
        values.put(ITEM_NAME, toDB);
        db.insert(TABLE_CART_ITEM, null, values);
        Log.d("DATA TABLE", "Inserted");
        db.close();
    }


    public boolean removeItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART_ITEM, KEY_ID + "=" + id, null) > 0;
    }

    public void addUserInfo(int id, String name, String email, String phone_number, boolean isLoggedIn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(USER_NAME, name);
        values.put(IS_LOGGED_IN, isLoggedIn);
        values.put(USER_EMAIL, email);
        values.put(USER_PHONE, phone_number);
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

    public boolean removeItemByBranchId(String branchID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART_ITEM, BRANCH_ID + "=" + branchID, null) > 0;
    }
}
