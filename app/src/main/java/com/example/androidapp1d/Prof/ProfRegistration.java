package com.example.androidapp1d.Prof;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.androidapp1d.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfRegistration extends AppCompatActivity {
    private EditText username, email, staffID, aboutme, office, venue,timeslotsize;
    private RadioGroup pillartaught;
    private Button modulesButton, register, availabilityPref;
    private String usernameInput, emailInput, staffIDinput, aboutmeInput, yearInput, officeInput,venueInput,timeslotsizeInput;
    private String[] modulesListItems;
    private String[] availabilityListItems;
    private boolean[] checkedModules, checkedAvail;
    private ArrayList<String> selectedmodulesList = new ArrayList<>();
    private ArrayList<String> selectedAvailabilityList = new ArrayList<>();
    private ArrayList<String> profsList = new ArrayList<>();
   // private ArrayList<String> selectedProfList = new ArrayList<>();
    private AlertDialog.Builder modsbuilder;
    private AlertDialog.Builder availBuilder;
    private FirebaseDatabase database;
    private DatabaseReference profRef;
    private String replaced;
    private String days;
    private ProfItem profItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_prof_registration);

            venue = (EditText) findViewById(R.id.venue);
            timeslotsize = (EditText) findViewById(R.id.timeslotsize);
            username = (EditText) findViewById(R.id.username);
            email = (EditText) findViewById(R.id.sutd_email);
            staffID = (EditText) findViewById(R.id.staffID);
            aboutme = (EditText) findViewById(R.id.prof_description);
            pillartaught = (RadioGroup) findViewById(R.id.pillartaught);
            modulesButton = (Button) findViewById(R.id.select_modules);
            register = (Button) findViewById(R.id.register);
            availabilityPref = (Button) findViewById(R.id.availabilityIndicator);
            office = (EditText)findViewById(R.id.office);
            database = FirebaseDatabase.getInstance();
            profRef = database.getReference().child("Professors");
            availabilityListItems = getResources().getStringArray(R.array.Availabilities);
            /*LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.alert_dialog_venue_timeslot_size, null);

            EditText venue = (EditText) dialogView.findViewById(R.id.venue);
            EditText timeslotsize = (EditText) dialogView.findViewById(R.id.timeslotsize);*/

           /* final EditText timeslotsize = new EditText(this);
            timeslotsize.setHint("Enter your preferred consultation slot duration");
            final EditText venue = new EditText(this);
            venue.setHint("Enter your preferred consultation venue");
            final RelativeLayout layout = new RelativeLayout(getApplicationContext());
            layout.addView(timeslotsize);
            layout.addView(venue);*/

            //register
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    usernameInput = username.getText().toString().trim();
                    emailInput = email.getText().toString().trim();
                    staffIDinput = staffID.getText().toString().trim();
                    aboutmeInput = aboutme.getText().toString().trim();
                    officeInput = office.getText().toString().trim();
                    venueInput = venue.getText().toString().trim();
                    timeslotsizeInput = timeslotsize.getText().toString().trim();
                    if (usernameInput.trim().isEmpty() || emailInput.isEmpty() || aboutmeInput.isEmpty() ||officeInput.isEmpty() || venueInput.isEmpty() || timeslotsizeInput.isEmpty()) {
                        Toast.makeText(ProfRegistration.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    } else if (selectedmodulesList.isEmpty() || selectedAvailabilityList.isEmpty()) {
                        Toast.makeText(ProfRegistration.this, "Please select your modules", Toast.LENGTH_SHORT).show();
                    } else {
                        profItem = new ProfItem(yearInput, aboutmeInput, emailInput,staffIDinput,officeInput,venueInput,timeslotsizeInput,selectedmodulesList,selectedAvailabilityList);
                        profRef.child(usernameInput).setValue(profItem);
                    }
                }
            });

            //get chosen module
            pillartaught.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.freshmore:
                            modulesListItems = getResources().getStringArray(R.array.freshmore_modules);
                            yearInput = "Freshmore";
                            break;
                        case R.id.ISTDpillar:
                            modulesListItems = getResources().getStringArray(R.array.ISTD_modules);
                            yearInput = "ISTD Pillar";
                            break;
                        case R.id.EPDpillar:
                            modulesListItems = getResources().getStringArray(R.array.EPD_modules);
                            yearInput = "EPD Pillar";
                            break;
                        case R.id.ESDpillar:
                            modulesListItems = getResources().getStringArray(R.array.ESD_modules);
                            yearInput = "ESD Pillar";
                            break;
                        case R.id.ASDpillar:
                            modulesListItems = getResources().getStringArray(R.array.ASD_modules);
                            yearInput = "ASD Pillar";
                            break;
                    }
                    Toast.makeText(ProfRegistration.this, yearInput, Toast.LENGTH_SHORT).show();
                }
            });

            //alert dialog to choose module
            modulesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pillartaught.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(ProfRegistration.this, "Select Freshmore/Pillar that you're teaching", Toast.LENGTH_SHORT).show();
                    } else {
                        checkedModules = new boolean[modulesListItems.length];
                        modsbuilder = new AlertDialog.Builder(ProfRegistration.this);
                        modsbuilder.setTitle("Select some modules that you open consulations for")
                                .setMultiChoiceItems(modulesListItems, checkedModules, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            if (!selectedmodulesList.contains(modulesListItems[which])){
                                                selectedmodulesList.add(modulesListItems[which]);
                                            }
                                        } else {
                                            selectedmodulesList.remove(modulesListItems[which]);
                                        }
                                    }
                                })
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (selectedmodulesList.isEmpty()) {
                                            Toast.makeText(ProfRegistration.this, "Please select some modules", Toast.LENGTH_SHORT).show();
                                        } else {
                                            //get profs under th selected mods
                                            for (int i = 0; i < selectedmodulesList.size(); i++) {
                                                replaced = selectedmodulesList.get(i).replaceAll("\\.", "\\'");
                                                profRef.child(replaced).addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        for (DataSnapshot profs : dataSnapshot.getChildren()) {
                                                            if (!profsList.contains(profs.getValue(String.class))) {
                                                                profsList.add(profs.getValue(String.class));
                                                            }
                                                        }
                                                    }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {
                                                    }
                                                });
                                            }
                                            Toast.makeText(ProfRegistration.this, "modules selected: \n"
                                                    + selectedmodulesList.toString(), Toast.LENGTH_LONG).show();
                                            dialog.dismiss();
                                        }
                                    }
                                })
                                .setNegativeButton("CLEAR ALL", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        for (int i = 0; i < checkedModules.length; i++) {
                                            checkedModules[i] = false;
                                            selectedmodulesList.clear();
                                        }
                                        dialog.dismiss();
                                    }
                                });
                        modsbuilder.create().show();
                    }
                }
            });

            //alert dialog to choose availability
            availabilityPref.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        checkedAvail = new boolean[availabilityListItems.length];
                        availBuilder = new AlertDialog.Builder(ProfRegistration.this);
                        availBuilder.setTitle("Select your availability preferences")
                                .setMultiChoiceItems(availabilityListItems, checkedAvail, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            if (!selectedAvailabilityList.contains(availabilityListItems[which])){
                                                selectedAvailabilityList.add(availabilityListItems[which]);
                                            }
                                        } else {
                                            selectedAvailabilityList.remove(availabilityListItems[which]);
                                        }
                                    }
                                })
                               // .setView(dialogView)
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (selectedAvailabilityList.isEmpty()) {
                                            Toast.makeText(ProfRegistration.this, "Please select your availabilities", Toast.LENGTH_SHORT).show();
                                        } else {
                                            //get profs under th selected availabilities
                                            for (int i = 0; i < selectedAvailabilityList.size(); i++) {
                                                days = selectedAvailabilityList.get(i);
                                                profRef.child(days).addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        for (DataSnapshot profs : dataSnapshot.getChildren()) {
                                                            if (!profsList.contains(profs.getValue(String.class))) {
                                                                profsList.add(profs.getValue(String.class));
                                                            }
                                                        }
                                                    }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {
                                                    }
                                                });
                                            }
                                            Toast.makeText(ProfRegistration.this, "Availabilities selected: \n"
                                                    + selectedAvailabilityList.toString(), Toast.LENGTH_LONG).show();
                                            dialog.dismiss();
                                        }
                                    }
                                })
                                .setNegativeButton("CLEAR ALL", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        for (int i = 0; i < checkedAvail.length; i++) {
                                            checkedAvail[i] = false;
                                            selectedAvailabilityList.clear();
                                        }
                                        dialog.dismiss();
                                    }
                                });
                        availBuilder.create().show();
                    }

            });


        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}