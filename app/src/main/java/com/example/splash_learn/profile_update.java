package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class profile_update extends AppCompatActivity {

    EditText nm, em, pa, clg;
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

                String email = em.getText().toString();
                String pass = pa.getText().toString();
                String clgName = clg.getText().toString();

                UserProfile userProfile = new UserProfile.Builder()
                        .setEmail(email)
                        .setPassword(pass)
                        .setCollegeName(clgName)
                        .build();

                DatabaseReference reference = FirebaseSingleton.getInstance().getDatabaseReference()
                        .child("DETAILS")
                        .child(login_activity.log_name);

                Command updateProfileCommand = new UpdateProfileCommand(reference, userProfile);
                updateProfileCommand.execute();

                startActivity(new Intent(profile_update.this, login_activity.class));
            }
        });
    }
}