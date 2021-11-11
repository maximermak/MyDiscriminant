package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "historyInput";

    public static final String TABLE_NAME = "history";

    public static final String KEY_ID = "_id";

    public static final String KEY_A = "a";

    public static final String KEY_B = "b";

    public static final String KEY_C = "c";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (" + KEY_ID + " integer primary key," + KEY_A + " text," + KEY_B + " text," + KEY_C + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
