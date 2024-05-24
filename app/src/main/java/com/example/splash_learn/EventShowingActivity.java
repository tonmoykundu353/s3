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
import com.example.splash_learn.SuperSingleton.SuperSingleton;
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

        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Eventinfo");
        DatabaseReference ref= SuperSingleton.getSuperSingleton();
        ref.child("Eventinfo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String eventName = eventSnapshot.child("eventName").getValue(String.class);
                    String eventDate = eventSnapshot.child("eventDate").getValue(String.class);
                    String eventPlace = eventSnapshot.child("eventPlace").getValue(String.class);
                    String eventRegFees = eventSnapshot.child("eventRegFees").getValue(String.class);
                    String organizedBy = eventSnapshot.child("organizedBy").getValue(String.class);
                    String clubname = eventSnapshot.child("clubname").getValue(String.class);

                    // Create an instance of EventShowinginfo with the retrieved data
                    EventSharedProperties eventSharedProperties=new EventSharedProperties(eventPlace,organizedBy);
                    EventShowinginfo eventInfo = new EventShowinginfo(clubname, eventDate, eventName, eventRegFees,eventSharedProperties);
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
                intent.putExtra("eventName", clickedEvent.getEventname());
                intent.putExtra("clubname", clickedEvent.getClubname());
                intent.putExtra("eventDate", clickedEvent.getEventdate());
                intent.putExtra("eventPlace", clickedEvent.getEventSharedProperties().getEventPlace());
                intent.putExtra("eventRegFees", clickedEvent.getEventRegFees());
                intent.putExtra("organizedBy", clickedEvent.getEventSharedProperties().getOrganizedBy());
                startActivity(intent);
            }
        });
    }
}
