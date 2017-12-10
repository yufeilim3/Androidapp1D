package com.example.androidapp1d.Prof;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidapp1d.LoginActivity;
import com.example.androidapp1d.R;

public class ProfFeedActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private TextView feedstub;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profactivitity_feed);
        getSupportActionBar().setTitle("Feed");


        /*ListView lv =(ListView)findViewById(R.id.profList);
        ArrayList<String> profList = new ArrayList<String>();
        profList.add("Oka Kurniawan");
        profList.add("Valerene Goh");
        profList.add("Cheryl Goh");
        profList.add("Nigel Chan");
        ArrayAdapter<String> lAdapter = new ArrayAdapter<String>(ProfFeedActivity.this,android.R.layout.simple_list_item_1,profList);
        lv.setAdapter(lAdapter);
        */

        drawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        final Menu menu1 =navigationView.getMenu();
        MenuItem dFeed = menu1.getItem(0);
        dFeed.setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.side_feed):
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case (R.id.side_booking):
                        Intent h= new Intent(ProfFeedActivity.this,ProfBookingActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.side_profile):
                        Intent i= new Intent(ProfFeedActivity.this,ProfProfileActivity.class);
                        startActivity(i);
                        break;
                }
                return  false;
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        final Menu menu = bottomNavigationView.getMenu();
        MenuItem bFeed = menu.getItem(0);
        bFeed.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.ic_feed):
                        break;
                    case (R.id.ic_booking):
                        Intent h= new Intent(ProfFeedActivity.this,ProfBookingActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.ic_profile):
                        Intent i= new Intent(ProfFeedActivity.this,ProfProfileActivity.class);
                        startActivity(i);
                        break;
                    case(R.id.ic_search):
                        Intent j= new Intent(ProfFeedActivity.this,ProfSearchActivity.class);
                        startActivity(j);
                        break;
                }
                return false;
            }
        });

        if (LoginActivity.accept1) {
            ((Button) findViewById(R.id.card01accept)).setText("ACCEPTED");
            //((Button) findViewById(R.id.card01accept)).setTextColor(Color.GREEN);
            ((Button) findViewById(R.id.card01accept)).setTextColor(Color.parseColor("#007D00"));
            ((Button) findViewById(R.id.card01accept)).setClickable(false);
            ((Button) findViewById(R.id.card01accept)).setBackgroundColor(View.INVISIBLE);
            ((Button) findViewById(R.id.card01reject)).setVisibility(View.INVISIBLE);
        }
        if (LoginActivity.reject1) {
            ((Button) findViewById(R.id.card01accept)).setText("REJECTED");
            ((Button) findViewById(R.id.card01accept)).setTextColor(Color.RED);
            //((Button) findViewById(R.id.card01accept)).setTextColor(Color.parseColor("#007D00"));
            ((Button) findViewById(R.id.card01accept)).setClickable(false);
            ((Button) findViewById(R.id.card01accept)).setBackgroundColor(View.INVISIBLE);

            ((Button) findViewById(R.id.card01reject)).setVisibility(View.INVISIBLE);
        }

    }

    public void card01ViewDetails (View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

       // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Topics covered: MOJO" + "\n" + "Venue: Digital Systems Lab" + "\n" + "Number of attendees: 1 pax (max 5)" + "\n" + "Initiator: Student Tracy Yee Enying" + "\n" + "Questions: How do I connect external IO devices to MOJO?")
                .setTitle("DETAILS");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void card02ViewDetails (View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Topics covered: Design Patterns" + "\n" + "Venue: Cohort Classroom 10 (Building 1 Level 4)" + "\n" + "Initiator: Prof Man" + "\n" + "Number of attendees: Everyone is welcome")
                .setTitle("DETAILS");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void card03ViewDetails (View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Student Tracy Yee Enying replied to the following line in ANNNOUNCEMENTS:" + "\n" + "2D Demo will be held this Friday." + "\n" + "Comment: For the SAT solver test, are there any more conclusive test cases provided as the current SAT test cases do not cover all the possibilities?")
                .setTitle("DETAILS");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void card04ViewDetails (View v) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Student Tracy Yee Enying cancelled the following consultation:" + "\n" + "08/12/17, Friday, 3:00pm" + "\n" + "Reason: Sorry Prof, I'm not feeling well today as I am down with fever and flu. I will book a makeup slot next week when I am better. Thanks for the understanding.")
                .setTitle("DETAILS");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void accept (View v) {
        ((Button) findViewById(R.id.card01accept)).setText("ACCEPTED");
        //((Button) findViewById(R.id.card01accept)).setTextColor(Color.GREEN);
        ((Button) findViewById(R.id.card01accept)).setTextColor(Color.parseColor("#007D00"));
        ((Button) findViewById(R.id.card01accept)).setClickable(false);
        ((Button) findViewById(R.id.card01accept)).setBackgroundColor(View.INVISIBLE);
        ((Button) findViewById(R.id.card01reject)).setVisibility(View.INVISIBLE);
        LoginActivity.accept1=true;
    }

    public void reject (View v) {
        ((Button) findViewById(R.id.card01accept)).setText("REJECTED");
        ((Button) findViewById(R.id.card01accept)).setTextColor(Color.RED);
        //((Button) findViewById(R.id.card01accept)).setTextColor(Color.parseColor("#007D00"));
        ((Button) findViewById(R.id.card01accept)).setClickable(false);
        ((Button) findViewById(R.id.card01accept)).setBackgroundColor(View.INVISIBLE);

        ((Button) findViewById(R.id.card01reject)).setVisibility(View.INVISIBLE);
        LoginActivity.reject1=true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profmenu_main,menu);
        return true;
    }

    public void goNotificationActivity(){
        startActivity(new Intent(this,ProfNotificationActivity.class)) ;
    }

    public void goSearchActivity(){
        startActivity(new Intent(this,ProfSearchActivity.class)) ;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==android.R.id.home) {
            if(drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView);
            }
            else{
                drawerLayout.openDrawer(navigationView);
            }
        }
        if (id==R.id.menu_item_add){
            goNotificationActivity();
        }
        if (id == R.id.ic_search){
            goSearchActivity();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

