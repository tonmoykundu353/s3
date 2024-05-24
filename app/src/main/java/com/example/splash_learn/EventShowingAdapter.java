package com.example.splash_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.splash_learn.FlyweightDP.EventSharedProperties;
import com.example.splash_learn.FlyweightDP.EventShowinginfo;

import java.util.ArrayList;

public class EventShowingAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<EventShowinginfo> arrayList;

    public EventShowingAdapter(Context context, ArrayList<EventShowinginfo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_event_showing_layout, parent, false);
        }
        EventShowinginfo eventShowinginfo = arrayList.get(position);
        TextView clubnameview = convertView.findViewById(R.id.id_showing_club_name);
        TextView eventnameview = convertView.findViewById(R.id.id_showing_event_name);
        TextView eventplaceview = convertView.findViewById(R.id.id_showing_event_place);
        TextView eventregFeesview = convertView.findViewById(R.id.id_showing_event_regFees);
        TextView eventdateview = convertView.findViewById(R.id.id_showing_event_date);

        clubnameview.setText(eventShowinginfo.getClubname());
        eventnameview.setText(eventShowinginfo.getEventname());
        eventregFeesview.setText(eventShowinginfo.getEventRegFees());
        eventdateview.setText(eventShowinginfo.getEventdate());

        // Use shared properties to set event place and organizer
        EventSharedProperties sharedProperties = eventShowinginfo.getEventSharedProperties();
        if (sharedProperties != null) {
            eventplaceview.setText(sharedProperties.getEventPlace());
            // You can set organizer wherever needed
        }

        return convertView;
    }
}

//this is changed by Dipesh*******************************