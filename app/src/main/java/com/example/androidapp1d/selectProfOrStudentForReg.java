package com.example.androidapp1d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidapp1d.Prof.ProfRegistration;
import com.example.androidapp1d.Stud.Booking.*;
import com.example.androidapp1d.Stud.Profile.StudRegistration;

public class selectProfOrStudentForReg extends AppCompatActivity {
    private Button amAStudent;
    private Button amAProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_prof_or_student_for_reg);
        amAStudent = (Button) findViewById(R.id.amAStud);
        amAProf = (Button) findViewById(R.id.amAProf);
    }

    public void IamAStudBtn(View view){
        Intent intent = new Intent(selectProfOrStudentForReg.this, StudRegistration.class);
        startActivity(intent);
    }


    public void IamAProfBtn(View view){
        Intent intent = new Intent(selectProfOrStudentForReg.this, ProfRegistration.class);
        startActivity(intent);
    }
}
