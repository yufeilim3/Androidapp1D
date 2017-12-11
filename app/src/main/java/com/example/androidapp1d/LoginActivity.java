package com.example.androidapp1d;

import android.content.Intent;
import android.os.Bundle;


import android.provider.MediaStore;

import android.support.annotation.NonNull;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.androidapp1d.Prof.ProfFeedActivity;
<<<<<<< HEAD

import com.example.androidapp1d.Stud.Booking.StudProfDetails;
import com.example.androidapp1d.Stud.Feed.StudFeedActivity;

import java.util.ArrayList;


import com.example.androidapp1d.Stud.Booking.StudRegistration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_LONG;

=======
import com.example.androidapp1d.Stud.Booking.StudBookingActivity;
>>>>>>> origin/Val

public class LoginActivity extends AppCompatActivity {
    //private Button loginbutton;
    //private Button tempbutton;
    private RadioButton student;
    private RadioButton prof;
    private Button enter;
    private Button register;
    public static ArrayList<String> list2; //list of modules
/*    public EditText username;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference proffirebaseref;*/

    public static boolean accept1 = false; // accept button for consultations in prof feed
    public static boolean reject1 = false; // reject button for consultations in prof feed
    public static ArrayList<String> list; // list of blocked students

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        //loginbutton = (Button) findViewById(R.id.loginbutton);
/*
        firebaseAuth = FirebaseAuth.getInstance();
        proffirebaseref = FirebaseDatabase.getInstance().getReference().child("Professors").child("email");
        if(firebaseAuth.getCurrentUser()!=null){

        }*/
        //username = (EditText) findViewById(R.id.enterUsername);
        enter = (Button) findViewById(R.id.enterapp);
        register = (Button) findViewById(R.id.signupbtn);
        student = (RadioButton) findViewById(R.id.student);
        prof = (RadioButton) findViewById(R.id.prof);

        list2 = new ArrayList<String>(); //DO NOT DELETE (for prof modules page)


        list = new ArrayList<String>(); // DO NOT DELETE (for prof reporting students page)

    }
        //register.setOnClickListener(this);
        //enter.setOnClickListener(new View.OnClickListener() {
           /* @Override
            public void onClick(View v) {
<<<<<<< HEAD

                if (student.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, StudFeedActivity.class);
                    startActivity(intent);
                } else if (prof.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, ProfFeedActivity.class);
                    startActivity(intent);
                }
                //Intent studentActivity = new Intent(LoginActivity.this, StudProfDetails.class);
                //startActivity(studentActivity);

                Intent studentActivity = new Intent(LoginActivity.this, StudRegistration.class);
=======
                Intent studentActivity = new Intent(LoginActivity.this, StudBookingActivity.class);
>>>>>>> origin/Val
                startActivity(studentActivity);

            }
        });*/
           public void buttonOnClick(View view){
        if (student.isChecked()) {
            Intent intent = new Intent(LoginActivity.this, StudFeedActivity.class);
            startActivity(intent);
        } else if (prof.isChecked()) {
            Intent intent = new Intent(LoginActivity.this, ProfFeedActivity.class);
            startActivity(intent);
        }

    }
        public void buttonOnClick2(View view){
            Intent selectPage = new Intent(LoginActivity.this, selectProfOrStudentForReg.class);
            startActivity(selectPage);
        }
/*
    private void userLogin(){
        String email = username.getText().toString().trim();

        //check if email is empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",LENGTH_LONG).show();
            return;
        }*/

 /*       firebaseAuth.signInWithEmailAndPassword(email,email).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //start profile activity
                }
            }
        });*/
    }

