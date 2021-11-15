package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "historyInput";

    public static final String TABLE_ABC = "history";

    public static final String TABLE_LP = "contacts";

    public static final String KEY_ID_FOR_LP = "_id_for_lp";

    public static final String KEY_ID = "_id";

    public static final String KEY_A = "a";

    public static final String KEY_B = "b";

    public static final String KEY_C = "c";

    public static final String LOGIN = "login";

    public static final String PASSWORD = "password";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table " + TABLE_ABC + " (" + KEY_ID + " integer primary key," + KEY_A + " text," + KEY_B + " text," + KEY_C + " text" + ")");
    sqLiteDatabase.execSQL("create table " + TABLE_LP + " (" + KEY_ID_FOR_LP + " integer primary key," + LOGIN + " text," + PASSWORD + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
