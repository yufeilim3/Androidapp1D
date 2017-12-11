package com.example.androidapp1d.Prof;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.androidapp1d.R;

import java.util.ArrayList;

/**
 * Created by e6440 on 12/11/2017.
 */

public class ProfBookingsAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    private Context context;


    public ProfBookingsAdapter(ArrayList<ArrayList<String>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
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
            view = inflater.inflate(R.layout.bookings_card, null);
        }

        //Handle TextView and display string from your list
        ((TextView)view.findViewById(R.id.bookingsTitle)).setText((list.get(position)).get(0));
        ((TextView)view.findViewById(R.id.bookingsProf)).setText((list.get(position)).get(1));
        ((TextView)view.findViewById(R.id.bookingsVenue)).setText((list.get(position)).get(2));
        ((TextView)view.findViewById(R.id.bookingsDate)).setText((list.get(position)).get(3));
        ((TextView)view.findViewById(R.id.bookingsDescription)).setText((list.get(position)).get(4));

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.bookingcardDeleteorWithdrawButton);
        //ImageButton detailsBtn = (ImageButton)view.findViewById(R.id.bookingcardDetailsButton);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });

        return view;
    }
}