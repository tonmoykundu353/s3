//package com.example.splash_learn;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrganizerActivity extends AppCompatActivity {
//    EditText eventname,clubname,eventdate,eventregFee;
//    Spinner eventplace;
//    Button addbtnobj;
//    String UserRoll;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_organizer);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//         UserRoll=getIntent().getStringExtra("UserRoll");
//
//        eventplace = findViewById(R.id.id_enter_Event_Place);
//
//        // Define your list of universities
//        List<String> universityList = new ArrayList<>();
//        universityList.add("KUET");
//        universityList.add("VUET");
//        universityList.add("CUER");
//        universityList.add("RUET");
//        // Add more universities as needed
//
//        // Create an ArrayAdapter using the university list
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, universityList);
//
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // Apply the adapter to the spinner
//        eventplace.setAdapter(adapter);
//
//
//        eventname=findViewById(R.id.id_enter_event_name);
//        clubname=findViewById(R.id.id_enter_organizing_club);
//        eventdate=findViewById(R.id.id_enter_event_date);
//        eventregFee=findViewById(R.id.id_enter_event_regFee);
//        addbtnobj=findViewById(R.id.addbtn);
//        addbtnobj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String event_place = eventplace.getSelectedItem().toString();
//                String event_name = eventname.getText().toString();
//                String club_name = clubname.getText().toString();
//                String event_date = eventdate.getText().toString();
//                String event_regFee=eventregFee.getText().toString();
//               Eventinfo eventinfo = new Eventinfo(club_name, event_name, event_place,event_regFee,event_date,UserRoll);
//                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Eventinfo").child(event_name);
//                ref.setValue(eventinfo);
//
//
//
////                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child(UserRoll).child("ClubSection");
////                ref2.setValue(eventinfo);
//                Toast.makeText(OrganizerActivity.this, "User information is successfully added", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//
//
//
//    }
//}







package com.example.splash_learn;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.splash_learn.DP.ConcreteInfoFactory;
import com.example.splash_learn.DP.InfoFactory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class OrganizerActivity extends AppCompatActivity {
    EditText eventname,clubname,eventdate,eventregFee;
    Spinner eventplace;
    Button addbtnobj;
    String UserRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_organizer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        UserRoll=getIntent().getStringExtra("UserRoll");

        eventplace = findViewById(R.id.id_enter_Event_Place);

        // Define your list of universities
        List<String> universityList = new ArrayList<>();
        universityList.add("KUET");
        universityList.add("BUET");
        universityList.add("CUET");
        universityList.add("RUET");
        // Add more universities as needed

        // Create an ArrayAdapter using the university list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, universityList);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        eventplace.setAdapter(adapter);


        eventname=findViewById(R.id.id_enter_event_name);
        clubname=findViewById(R.id.id_enter_organizing_club);
        eventdate=findViewById(R.id.id_enter_event_date);
        eventregFee=findViewById(R.id.id_enter_event_regFee);
        addbtnobj=findViewById(R.id.addbtn);
        addbtnobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event_place = eventplace.getSelectedItem().toString();
                String event_name = eventname.getText().toString();
                String club_name = clubname.getText().toString();
                String event_date = eventdate.getText().toString();
                String event_regFee=eventregFee.getText().toString();
                //Eventinfo eventinfo = new Eventinfo(club_name, event_name, event_place,event_regFee,event_date,UserRoll);
                //**************************************Using Factory DP*************************************
                //*******************************************************************************************
                InfoFactory factory = new ConcreteInfoFactory();
                Eventinfo eventinfo = factory.createEventinfo(club_name, event_name, event_place,event_regFee,event_date,UserRoll);






                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Eventinfo").child(event_name);
                ref.setValue(eventinfo);



//                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child(UserRoll).child("ClubSection");
//                ref2.setValue(eventinfo);
                Toast.makeText(OrganizerActivity.this, "User information is successfully added", Toast.LENGTH_SHORT).show();


            }
        });




    }
}



