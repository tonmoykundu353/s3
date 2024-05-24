package com.example.splash_learn;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
import java.util.List;

public class OrganizerLoginActivity2 extends AppCompatActivity {
    EditText organizer_university_rollobj2, organizer_university_passwordobj2;

    CheckBox checkBox;
    Button Loginbtn2,organizerregistration2;
    Spinner universitySpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_organizer_login2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        universitySpinner2 = findViewById(R.id.id_enter_organizer_university_spinner2);
        organizer_university_rollobj2 = findViewById(R.id.id_enter_organizer_roll2);
        organizer_university_passwordobj2 = findViewById(R.id.id_enter_organizer_password2);
        Loginbtn2 = findViewById(R.id.id_organizer_login_btn2);
        organizerregistration2=findViewById(R.id.id_organizer_registration2);

        checkBox = findViewById(R.id.organizer_checkbox_button2);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // For show password
                    organizer_university_passwordobj2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    // For hide password
                    organizer_university_passwordobj2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }

        });

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
        universitySpinner2.setAdapter(adapter);


//        Loginbtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String University_name = universitySpinner2.getSelectedItem().toString();
//                String University_roll = organizer_university_rollobj2.getText().toString();
//                String University_password = organizer_university_passwordobj2.getText().toString();
//                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child(University_roll);
//                ref.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            String uni_n=snapshot.child("uni_name").getValue(String.class);
//                            String uni_pass=snapshot.child("uni_password").getValue(String.class);
//                            String uni_roll=snapshot.child("uni_roll").getValue(String.class);
//
//                            // Check if university name, roll number, and password match
//                            if(University_name.equals(uni_n) && University_roll.equals(uni_roll) && University_password.equals(uni_pass)){
//                                Toast.makeText(OrganizerLoginActivity2.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
////                                Intent intent = new Intent(OrganizerLoginActivity2.this, OrganizerActivity.class);
////                                intent.putExtra("UserRoll", University_roll);
////                                startActivity(intent);
//
//
//
//                                Intent intent = new Intent(OrganizerLoginActivity2.this, ChoiceBoxOrganizerActivity.class);
//                                intent.putExtra("UserRoll", University_roll);
//                                startActivity(intent);
//
//
//                            } else {
//                                Toast.makeText(OrganizerLoginActivity2.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(OrganizerLoginActivity2.this, "User not found", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//            }
//        });
        Loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input values
                String University_name = universitySpinner2.getSelectedItem().toString();
                String University_roll = organizer_university_rollobj2.getText().toString().trim();
                String University_password = organizer_university_passwordobj2.getText().toString().trim();

                // Check if any input field is empty
                if (University_name.isEmpty() || University_roll.isEmpty() || University_password.isEmpty()) {
                    Toast.makeText(OrganizerLoginActivity2.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Prevent further execution
                }


                // Proceed with login authentication
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("OrganizerRegistrationSection").child(University_roll);
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String uni_n = snapshot.child("uni_name").getValue(String.class);
                            String uni_pass = snapshot.child("uni_password").getValue(String.class);
                            String uni_roll = snapshot.child("uni_roll").getValue(String.class);

                            // Check if university name, roll number, and password match
                            if(University_name.equals(uni_n) && University_roll.equals(uni_roll) && University_password.equals(uni_pass)){
                                Toast.makeText(OrganizerLoginActivity2.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();

                                // Proceed to next activity
                                Intent intent = new Intent(OrganizerLoginActivity2.this, ChoiceBoxOrganizerActivity.class);
                                intent.putExtra("UserRoll", University_roll);
                                startActivity(intent);

                            } else {
                                Toast.makeText(OrganizerLoginActivity2.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(OrganizerLoginActivity2.this, "User not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle database error
                    }
                });
            }
        });




        organizerregistration2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrganizerLoginActivity2.this,OrganizerLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}