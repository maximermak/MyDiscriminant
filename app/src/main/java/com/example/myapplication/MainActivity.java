package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button entBut;
    TextView password, login, error;
    public int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = (TextView) findViewById(R.id.error);

        error.setTextColor(Color.RED);

        entBut = (Button) findViewById(R.id.Enter);

        password = (TextView) findViewById(R.id.editTextTextPassword);

        login = (TextView) findViewById(R.id.editTextTextEmailAddress);

        Intent intent = new Intent(this, MainActivity2.class);

        String myLog = "admin";

        String myPass = "admin";




        String nowPass = password.getText().toString();

        entBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myLog.equals(login.getText().toString()) && myPass.equals(password.getText().toString()) && score < 4)
                {
                    startActivity(intent);
                }
                else
                {
                    Handler myHandler = new Handler();
                    myHandler.postDelayed(new Runnable() {
                        public void run() {
                        System.out.println(1);
                        score = 0;
                        }
                    }, 5000);
                    score++;
                    error.setText("Неправильный логин или пароль.");
                    if(score > 4)
                    {
                        error.setText("Повторите позже.");
                    }
                }

            }
        });


    }
}