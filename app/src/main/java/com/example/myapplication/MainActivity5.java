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

    Button createBut;
    TextView login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        login = (TextView) findViewById(R.id.inputerLogin);

        password = (TextView) findViewById(R.id.inputerPassword);

        createBut = (Button) findViewById(R.id.toCreate);

        Intent intent = new Intent(this, MainActivity.class);


        createBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newLogin = login.getText().toString();

                String newPassword = password.getText().toString();

                if(!newLogin.equals("") && !newPassword.equals(""))
                {
                    contentValues.put(DBHelper.LOGIN, newLogin);
                    contentValues.put(DBHelper.PASSWORD, newPassword);
                    database.insert(DBHelper.TABLE_LP,null, contentValues);
                    startActivity(intent);
                }
            }
        });

    }
}