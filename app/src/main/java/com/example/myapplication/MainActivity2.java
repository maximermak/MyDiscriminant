package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    int a,b,c;
    String accumulate = "";
    Button read;
    FloatingActionButton nextPage;
    TextView tvA, tvB, tvC, toSee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nextPage = (FloatingActionButton) findViewById(R.id.page12);

        tvA = (TextView) findViewById(R.id.tieA);

        tvB = (TextView) findViewById(R.id.tieB);

        tvC = (TextView) findViewById(R.id.tieC);

        read = (Button) findViewById(R.id.reader);

        toSee = (TextView) findViewById(R.id.toSeeAText);

        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        Intent intent = new Intent(this, MainActivity3.class);




        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if(!tvA.getText().toString().equals("") && !tvB.getText().toString().equals("") && !tvC.getText().toString().equals("")) {
                        a = Integer.parseInt(tvA.getText().toString());
                        b = Integer.parseInt(tvB.getText().toString());
                        c = Integer.parseInt(tvC.getText().toString());
                        contentValues.put(DBHelper.KEY_A, a);
                        contentValues.put(DBHelper.KEY_B, b);
                        contentValues.put(DBHelper.KEY_C, c);
                        database.insert(DBHelper.TABLE_NAME, null, contentValues);
                        toSee.setText(Discriminant.discText(a, b, c));


                        Cursor cursor = database.query(DBHelper.TABLE_NAME, null,null,null,null,null,null);
                        if(cursor.moveToFirst())
                        {
                            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                            int aIndex = cursor.getColumnIndex(DBHelper.KEY_A);
                            int bIndex = cursor.getColumnIndex(DBHelper.KEY_B);
                            int cIndex = cursor.getColumnIndex(DBHelper.KEY_C);
                            do {
                                String tmpString = "\n" + cursor.getInt(idIndex) + ": a = " + cursor.getInt(aIndex) + ", b = " + cursor.getInt(bIndex)
                                        + ", c = " + cursor.getInt(cIndex);
                                accumulate += tmpString;
                            }
                            while (cursor.moveToNext());
                            cursor.close();
                            intent.putExtra("historyText", accumulate);
                        }
                    }


            }
        };
        tvA.addTextChangedListener(textWatcher);
        tvB.addTextChangedListener(textWatcher);
        tvC.addTextChangedListener(textWatcher);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });






    }
}