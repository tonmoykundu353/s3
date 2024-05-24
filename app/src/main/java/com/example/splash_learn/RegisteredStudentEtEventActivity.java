package com.example.splash_learn;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegisteredStudentEtEventActivity extends AppCompatActivity {
    ListView listView;
    RegStudAtEventAdapter regStudAtEventAdapter;
    ArrayList<RegStudAtEventInfo> arrayList;

    String UserRoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registered_student_et_event);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        UserRoll=getIntent().getStringExtra("UserRoll");

        UserRoll = getIntent().getStringExtra("UserRoll");
        if (UserRoll == null) {
            // Handle the case when UserRoll is null
            // For example, show an error message or return early
            return;
        }




        arrayList=new ArrayList<>();
        listView=findViewById(R.id.Reg_stud_at_event_listview_id);
        regStudAtEventAdapter=new RegStudAtEventAdapter(this,arrayList);
        listView.setAdapter(regStudAtEventAdapter);

        DatabaseReference root= FirebaseDatabase.getInstance().getReference().child("Contestentinfo").child(UserRoll);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    RegStudAtEventInfo registrationInfo=dataSnapshot.getValue(RegStudAtEventInfo.class);
                    if(registrationInfo!=null){
                        arrayList.add(registrationInfo);
                    }
                }
                regStudAtEventAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}