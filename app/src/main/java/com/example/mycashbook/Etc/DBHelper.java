package com.example.mycashbook.Etc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyAccount.db";
    public static final String CONFIG_TABLE_NAME = "config";
    public static final String ACCOUNT_TABLE_NAME = "account";


    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + CONFIG_TABLE_NAME + " (id INTEGER PRIMARY KEY autoincrement, budget INTEGER, startdate INTEGER);");
        db.execSQL("CREATE TABLE " + ACCOUNT_TABLE_NAME + " (id INTEGER PRIMARY KEY, card TEXT, date TEXT, money INTEGER, place TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CONFIG_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TABLE_NAME);
        onCreate(db);
    }

    public void setConfig(int budget, int startdate){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO "  + CONFIG_TABLE_NAME + " ( budget, startdate ) values (" + budget + ", " + startdate + " )");
        db.close();
    }
}
