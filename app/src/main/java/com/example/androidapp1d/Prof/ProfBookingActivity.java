package com.example.androidapp1d.Prof;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.androidapp1d.LoginActivity;
import com.example.androidapp1d.R;

import java.util.ArrayList;

public class ProfBookingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profactivity_booking);
        getSupportActionBar().setTitle("Your Booked Slots");
        drawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        final Menu menu1 =navigationView.getMenu();
        MenuItem dBooking = menu1.getItem(1);
        dBooking.setChecked(true);

        //generate list
        ArrayList<String> card01 = new ArrayList<String>();
        card01.add("50.001 Consultation Slot");
        card01.add("Student Tracy Yee");
        card01.add("Cohort Classroom 13");
        card01.add("11 December");
        card01.add("Need help for 1D Information Systems Project");

        ArrayList<String> card02 = new ArrayList<String>();
        card02.add("50.002 Consultation Slot");
        card02.add("Student Tracy Yee");
        card02.add("Cohort Classroom 14");
        card02.add("12 December");
        card02.add("Revision for Quiz 3");

        ArrayList<String> card03 = new ArrayList<String>();
        card03.add("50.004 Consultation Slot");
        card03.add("Student Tracy Yee");
        card03.add("Cohort Classroom 14");
        card03.add("12 December");
        card03.add("Revision for Quiz 3");

        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(card01);
        list.add(card02);
        list.add(card03);

        //instantiate custom adapter
        ProfBookingsAdapter adapter = new ProfBookingsAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.profList);
        lView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.side_feed):
                        Intent h= new Intent(ProfBookingActivity.this,ProfFeedActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.side_booking):
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case (R.id.side_profile):
                        Intent i= new Intent(ProfBookingActivity.this,ProfProfileActivity.class);
                        startActivity(i);
                        break;
                    case(R.id.ic_search):
                        Intent j= new Intent(ProfBookingActivity.this,ProfSearchActivity.class);
                        startActivity(j);
                        break;
                    case(R.id.side_logout):
                        Intent k = new Intent(ProfBookingActivity.this,LoginActivity.class);
                        startActivity(k);
                }
                return  false;
            }
        });



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem bBooking = menu.getItem(1);
        bBooking.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case (R.id.ic_feed):
                        Intent h= new Intent(ProfBookingActivity.this,ProfFeedActivity.class);
                        startActivity(h);
                        break;
                    case (R.id.ic_booking):
                        break;
                    case (R.id.ic_profile):
                        Intent i= new Intent(ProfBookingActivity.this,ProfProfileActivity.class);
                        startActivity(i);
                        break;
                    case(R.id.ic_search):
                        Intent j= new Intent(ProfBookingActivity.this,ProfSearchActivity.class);
                        startActivity(j);
                        break;
                    case(R.id.side_logout):
                        Intent k = new Intent(ProfBookingActivity.this,LoginActivity.class);
                        startActivity(k);
                        break;

                }


                return false;
            }
        });
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
