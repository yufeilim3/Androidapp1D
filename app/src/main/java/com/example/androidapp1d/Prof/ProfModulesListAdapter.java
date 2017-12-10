package com.example.androidapp1d.Prof;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.androidapp1d.R;

import java.util.ArrayList;

import static com.example.androidapp1d.LoginActivity.list2;

/**
 * Created by Cheryl Goh on 10/12/2017.
 */

public class ProfModulesListAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> listmod = new ArrayList<String>();
    private Context context;


    public ProfModulesListAdapter(ArrayList<String> listmod, Context context) {
        this.listmod = list2;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list2.size();
    }

    @Override
    public Object getItem(int pos) {
        return list2.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        //return list.get(pos).getId();
        return 0; //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listofmods, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.modulename);
        listItemText.setText(list2.get(position));

        //Handle buttons and add onClickListeners
        ImageButton deleteBtn = (ImageButton)view.findViewById(R.id.delete_button);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list2.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
