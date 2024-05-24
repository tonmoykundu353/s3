package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_activity extends AppCompatActivity {


    CheckBox checkbox_btn;
   public static EditText sign_up_password,sign_up_username,sign_up_name,sign_up_college_name;
    Button sign_up_button;

    public static String email,password,college_name,user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        checkbox_btn = findViewById(R.id.checkbox_button2);
        sign_up_password = findViewById(R.id.sign_up_password);
        sign_up_username = findViewById(R.id.sign_up_username);
        sign_up_name = findViewById(R.id.sign_up_name);
        sign_up_college_name = findViewById(R.id.sign_up_college_name);
        sign_up_button = findViewById(R.id.sign_up_button);

        checkbox_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // For show password
                    sign_up_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    // For hide password
                    sign_up_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = sign_up_username.getText().toString();
                 password = sign_up_password.getText().toString();
                college_name = sign_up_college_name.getText().toString();
                user_name = sign_up_name.getText().toString();

                //
                if(!email.contains("@gmail.com"))
                {
                    Toast.makeText(signup_activity.this, "Enter a valid gmail", Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<6)
                {
                    Toast.makeText(signup_activity.this, "password less than 6 charecters", Toast.LENGTH_SHORT).show();
                }
                //
                else {
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("DETAILS").child(user_name);
                    UserInfo userInfo = new UserInfo(user_name, password, college_name, email);

                    databaseReference.setValue(userInfo);
                    Toast.makeText(signup_activity.this, "succesfully signed up", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup_activity.this, login_activity.class);
                    startActivity(intent);

                }

            }
        });

    }
}