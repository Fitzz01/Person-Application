package com.example.individualproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table users(name TEXT, password TEXT, Phone TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists users");
    }

    public boolean insertData(String name, String password, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("phone", phone);

        long result = db.insert("users", null, contentValues);
        if(result == -1){
            return false;
        }else
            return true;
    }

    public boolean checkUser(String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where phone =?", new String[]{phone});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }

    public boolean checkPhoneAndPass(String password, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where password =? and phone =?", new String[]{password,phone});
        if(cursor.getCount() > 0){
            return true;
        }else
            return false;
    }
}
