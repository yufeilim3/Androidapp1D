package com.example.androidapp1d.Prof;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidapp1d.LoginActivity;
import com.example.androidapp1d.R;

public class ProfModulesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_modules_list);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Modules");

        ProfModulesListAdapter modadapter = new ProfModulesListAdapter(LoginActivity.list2,this);
//handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listofmodules);
        lView.setAdapter(modadapter);

        ((ImageButton) findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((EditText)findViewById(R.id.inputmodulestaught)).getText().toString().matches("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter a module";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    LoginActivity.list2.add(((EditText) findViewById(R.id.inputmodulestaught)).getText().toString());
                    //instantiate custom adapter
                    ProfModulesListAdapter adapter = new ProfModulesListAdapter(LoginActivity.list2, ProfModulesList.this);

                    //handle listview and assign adapter
                    ListView lView = (ListView) findViewById(R.id.listofmodules);
                    lView.setAdapter(adapter);
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        if(id==android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
