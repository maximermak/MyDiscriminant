package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    String nowLog, nowPass;
    Button createBut;
    TextView login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        login = (TextView) findViewById(R.id.inputerLogin);

        password = (TextView) findViewById(R.id.inputerPassword);

        createBut = (Button) findViewById(R.id.toCreate);

        Intent intent = new Intent(this, MainActivity.class);

        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues =  new ContentValues();

        createBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!login.getText().toString().trim().equals("") && !password.getText().toString().trim().equals(""))
                 nowLog = login.getText().toString();
                 nowPass = password.getText().toString();
                 contentValues.put(DBHelper.KEY_LOGIN, nowLog);
                 contentValues.put(DBHelper.KEY_PASSWORD, nowPass);
                 database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                 startActivity(intent);
            }
        });

    }
}