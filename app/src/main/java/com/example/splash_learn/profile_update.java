package com.example.splash_learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class profile_update extends AppCompatActivity {

    String name,email,pass,clg_name;
    EditText nm,em,pa,clg;


    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);


        pa = findViewById(R.id.sign_up_password1);
        em = findViewById(R.id.sign_up_username1);
        clg = findViewById(R.id.sign_up_college_name1);
        update = findViewById(R.id.update_button);





        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(profile_update.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
               DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("DETAILS").child(login_activity.log_name);

                email = em.getText().toString();
                pass = pa.getText().toString();
                clg_name = clg.getText().toString();


               Map<String, Object> hashMap = new HashMap<>();

                hashMap.put("password", pass);

                hashMap.put("email", email);

                hashMap.put("college_name", clg_name);
                reference.updateChildren(hashMap);
                startActivity(new Intent(profile_update.this, login_activity.class));


            }
        });

    }
}

