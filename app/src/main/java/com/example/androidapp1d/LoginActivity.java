package com.example.androidapp1d;

import android.content.Intent;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    //private Button loginbutton;
    //private Button tempbutton;
    private RadioButton student;
    private RadioButton prof;
    private Button enter;
    static boolean accept1 = false;
    static boolean reject1 = false;
    static ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        //loginbutton = (Button) findViewById(R.id.loginbutton);
        enter = (Button) findViewById(R.id.enterapp);
        student = (RadioButton) findViewById(R.id.student);
        prof = (RadioButton) findViewById(R.id.prof);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (student.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, StudFeedActivity.class);
                    startActivity(intent);
                } else if (prof.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, ProfFeedActivity.class);
                    startActivity(intent);
                }

            }
        });
        list = new ArrayList<String>();

    }
}