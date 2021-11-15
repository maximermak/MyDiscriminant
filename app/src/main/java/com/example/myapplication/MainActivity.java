package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String nowPass, nowLog;
    Button entBut;
    TextView password, login, error, signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView) findViewById(R.id.sign_up);

        error = (TextView) findViewById(R.id.error);

        error.setTextColor(Color.RED);

        entBut = (Button) findViewById(R.id.Enter);

        password = (TextView) findViewById(R.id.editTextTextPassword);

        login = (TextView) findViewById(R.id.editTextTextEmailAddress);

        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase database1 = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        Intent intentRegistration = new Intent(this, MainActivity5.class);

        Intent intent = new Intent(this, MainActivity2.class);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentRegistration);
            }
        });

        entBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor1 = database1.query(DBHelper.TABLE_LP, null,null,null,null,null,null);

                if(cursor1.moveToFirst()) {
                    int loginIndex = cursor1.getColumnIndex(DBHelper.LOGIN);
                    int passwordIndex = cursor1.getColumnIndex(DBHelper.PASSWORD);
                    do {
                        System.out.println(1);
                    }
                    while (cursor1.moveToNext());
                }
            }
        });

//        entBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                Cursor cursor = database.query(DBHelper.TABLE_LP, null,null,null,null,null,null);
//                nowLog = login.getText().toString();
//                nowPass = login.getText().toString();
//                if(cursor.moveToFirst())
//                {
//                    int loginIndex = cursor.getColumnIndex(DBHelper.LOGIN);
//                    int passwordIndex = cursor.getColumnIndex(DBHelper.PASSWORD);
//                    do {
//                        String tmpLogin = "" + cursor.getInt(loginIndex);
//                        String tmpPassword = "" + cursor.getInt(passwordIndex);
//                            if(nowLog.equals(tmpLogin) && nowPass.equals(tmpPassword))
//                            {
//                                startActivity(intent);
//                            }
//                    }
//                    while(cursor.moveToNext());
//                }
//                else {
//                    error.setText("Неправильный логин или пароль.");
//                }
//
//            }
//        });


    }
}