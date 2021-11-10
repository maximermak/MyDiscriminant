package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    int a,b,c;
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

        toSee = (TextView) findViewById(R.id.toSeeAText);


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
                        toSee.setText(Discriminant.discText(a, b, c));
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