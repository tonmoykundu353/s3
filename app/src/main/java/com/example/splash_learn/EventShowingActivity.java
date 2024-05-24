//package com.example.splash_learn;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class EventShowingActivity extends AppCompatActivity {
//    ListView listviewobj;
//    EventShowingAdapter eventShowingAdapter;
//    ArrayList<EventShowinginfo> arrayList;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_event_showing);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        arrayList = new ArrayList<>();
//        listviewobj = findViewById(R.id.id_event_showing_listview);
//        eventShowingAdapter = new EventShowingAdapter(this, arrayList);
//        listviewobj.setAdapter(eventShowingAdapter);
//
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Eventinfo");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
//                    String eventName = eventSnapshot.child("eventName").getValue(String.class);
//                    String eventDate = eventSnapshot.child("eventDate").getValue(String.class);
//                    String eventPlace = eventSnapshot.child("eventPlace").getValue(String.class);
//                    String eventRegFees = eventSnapshot.child("eventRegFees").getValue(String.class);
//                    String organizedBy = eventSnapshot.child("organizedBy").getValue(String.class);
//                    String clubname = eventSnapshot.child("clubname").getValue(String.class);
//
//                    // Filter out events like "CSEday" and "EEEday"
////                    if ("CSEday".equals(eventName) || "EEEday".equals(eventName)) {
////                        EventShowinginfo eventInfo = new EventShowinginfo(eventName, clubname, eventDate, eventPlace, eventRegFees, organizedBy);
////                        arrayList.add(eventInfo);
////                    }
//
//
//
//
//                    EventShowinginfo eventInfo = new EventShowinginfo(eventName, clubname, eventDate, eventPlace, eventRegFees, organizedBy);
//                    arrayList.add(eventInfo);
//
//
//
//                }
//                // Notify adapter after adding data
//                eventShowingAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle database error
//            }
//        });
//
//
//
//
//
//
//
//
//        // Set item click listener for ListView
//        listviewobj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Get the clicked item
//                EventShowinginfo clickedEvent = arrayList.get(position);
//
//                // Start DetailofEventActivity and pass the event details
//                Intent intent = new Intent(EventShowingActivity.this, DetailofEventShowingActivity.class);
//                intent.putExtra("eventName", clickedEvent.getEventname());
//                intent.putExtra("clubname", clickedEvent.getClubname());
//                intent.putExtra("eventDate", clickedEvent.getEventdate());
//                intent.putExtra("eventPlace", clickedEvent.getEventplace());
//                intent.putExtra("eventRegFees", clickedEvent.getEventRegFees());
//                intent.putExtra("organizedBy", clickedEvent.getOrganizedBy());
//                startActivity(intent);
//
//            }
//
//
//        });
//    }
//
//}
























// EventShowingActivity.java
package com.example.splash_learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.splash_learn.FlyweightDP.EventSharedProperties;
import com.example.splash_learn.FlyweightDP.EventSharedPropertiesFactory;
import com.example.splash_learn.FlyweightDP.EventShowinginfo;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventShowingActivity extends AppCompatActivity {
    ListView listviewobj;
    EventShowingAdapter eventShowingAdapter;
    ArrayList<EventShowinginfo> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_showing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        arrayList = new ArrayList<>();
        listviewobj = findViewById(R.id.id_event_showing_listview);
        eventShowingAdapter = new EventShowingAdapter(this, arrayList);
        listviewobj.setAdapter(eventShowingAdapter);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Eventinfo");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String eventName = eventSnapshot.child("eventName").getValue(String.class);
                    String eventDate = eventSnapshot.child("eventDate").getValue(String.class);
                    String eventPlace = eventSnapshot.child("eventPlace").getValue(String.class);
                    String eventRegFees = eventSnapshot.child("eventRegFees").getValue(String.class);
                    String organizedBy = eventSnapshot.child("organizedBy").getValue(String.class);
                    String clubname = eventSnapshot.child("clubname").getValue(String.class);

                    // Get the shared properties
                    EventSharedProperties sharedProperties = EventSharedPropertiesFactory.getEventSharedProperties(eventPlace, organizedBy);

                    // Create the EventShowinginfo object with the shared properties
                    EventShowinginfo eventInfo = new EventShowinginfo( eventName,clubname, eventDate,eventRegFees, sharedProperties);
                    arrayList.add(eventInfo);
                }
                // Notify adapter after adding data
                eventShowingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });

        // Set item click listener for ListView
        listviewobj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item
                EventShowinginfo clickedEvent = arrayList.get(position);

                // Start DetailofEventActivity and pass the event details
                Intent intent = new Intent(EventShowingActivity.this, DetailofEventShowingActivity.class);
                intent.putExtra("eventName", clickedEvent.getEventName());
                intent.putExtra("clubname", clickedEvent.getClubname());
                intent.putExtra("eventDate", clickedEvent.getEventDate());
                intent.putExtra("eventPlace", clickedEvent.getSharedProperties().getEventPlace());
                intent.putExtra("eventRegFees", clickedEvent.getEventRegFees());
                intent.putExtra("organizedBy", clickedEvent.getSharedProperties().getOrganizedBy());
                startActivity(intent);
            }
        });
    }
}
