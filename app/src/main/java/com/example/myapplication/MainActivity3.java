package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {
FloatingActionButton nextPage, lastPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nextPage = (FloatingActionButton) findViewById(R.id.page2_3);

        lastPage = (FloatingActionButton) findViewById(R.id.page2_1);

        Intent intent1 = new Intent(this, MainActivity2.class);

        Intent intent2 = new Intent(this, MainActivity4.class);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

        lastPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}