//package com.example.splash_learn;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class DetailofEventShowingActivity extends AppCompatActivity {
//    EditText contestentname,contestentemail,ContactNo;
//    Button registerbtn;
//
//
//    String User;
//
//
//
//    String contestentnameobj,contestentemailobj,ContactNoobj;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_detailof_event_showing);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//
//        ContactNo=findViewById(R.id.contestent_college);
//        contestentname=findViewById(R.id.contestent_name);
//        contestentemail=findViewById(R.id.contestent_email);
//        registerbtn=findViewById(R.id.regbtn_for_contest);
//        registerbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                contestentnameobj=contestentname.getText().toString();
//                contestentemailobj=contestentemail.getText().toString();
//                ContactNoobj=ContactNo.getText().toString();
//
//
//
//                User=getIntent().getStringExtra("organizedBy");
//
//
//
//
//
//
//
//                //Using Factory Design Pattern***********************************************************************
//                //*************************************************************************************************
//                Contestentinfo contestentinfo = new Contestentinfo(contestentnameobj, contestentemailobj,ContactNoobj);
//
//
//
//
//
//
//                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Contestentinfo").child(User).child(contestentnameobj);
//                ref.setValue(contestentinfo);
//
//
//
////                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child(UserRoll).child("ClubSection");
////                ref2.setValue(eventinfo);
//                Toast.makeText(DetailofEventShowingActivity.this, "User information is successfully added", Toast.LENGTH_SHORT).show();
//
//
//
//            }
//        });
//    }
//}













package com.example.splash_learn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class DetailofEventShowingActivity extends AppCompatActivity {
    EditText contestentname, contestentemail, ContactNo;
    Button registerbtn;

    String User;
    String contestentnameobj, contestentemailobj, ContactNoobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailof_event_showing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ContactNo = findViewById(R.id.contestent_college);
        contestentname = findViewById(R.id.contestent_name);
        contestentemail = findViewById(R.id.contestent_email);
        registerbtn = findViewById(R.id.regbtn_for_contest);

        User = getIntent().getStringExtra("organizedBy");

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestentnameobj = contestentname.getText().toString();
                contestentemailobj = contestentemail.getText().toString();
                ContactNoobj = ContactNo.getText().toString();


                // Validation checks
                if (!contestentemailobj.endsWith("@gmail.com")) {
                    Toast.makeText(DetailofEventShowingActivity.this, "Email must be a @gmail.com address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ContactNoobj.length() != 11) {
                    Toast.makeText(DetailofEventShowingActivity.this, "Mobile number must be 11 digits", Toast.LENGTH_SHORT).show();
                    return;
                }




                // Use Factory Design Pattern to create Contestentinfo instance
                InfoFactory factory = new ConcreteInfoFactory();
                Contestentinfo contestentinfo = factory.createContestentinfo(contestentnameobj, contestentemailobj, ContactNoobj);



                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Contestentinfo").child(User).child(contestentnameobj);
                ref.setValue(contestentinfo);

                Toast.makeText(DetailofEventShowingActivity.this, "User information is successfully added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
