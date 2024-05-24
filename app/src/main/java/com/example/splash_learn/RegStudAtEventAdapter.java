package com.example.splash_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RegStudAtEventAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RegStudAtEventInfo> data;

    // Corrected constructor
    public RegStudAtEventAdapter(Context context, ArrayList<RegStudAtEventInfo> arrayList) {
        this.context = context;
        this.data = arrayList;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate your custom view and return it here
        // For example:
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_for_showing_reg_atud_at_event,parent,false);
        }

       RegStudAtEventInfo regStudAtEventInfodata=data.get(position);
        TextView nametetxview=convertView.findViewById(R.id.stud_name);
        TextView emailtextview=convertView.findViewById(R.id.stud_email);
        TextView contactview=convertView.findViewById(R.id.stud_contact);


        nametetxview.setText(regStudAtEventInfodata.getName());
        emailtextview.setText(regStudAtEventInfodata.getEmail());
        contactview.setText(regStudAtEventInfodata.getContactNo());

        return convertView;
    }
}
