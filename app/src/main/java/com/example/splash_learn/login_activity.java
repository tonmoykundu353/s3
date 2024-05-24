package com.example.splash_learn;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_activity extends AppCompatActivity {

    CheckBox checkbox_btn;
    EditText login_password,login_name;

    TextView sign_up;

    Button login;

    public static String log_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkbox_btn = findViewById(R.id.checkbox_button);
        login_password = findViewById(R.id.login_password);
        login_name = findViewById(R.id.login_name);
        sign_up = findViewById(R.id.sign_up);
        login = findViewById(R.id.login_button);

        checkbox_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // For show password
                    login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    // For hide password
                    login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }

        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_activity.this, signup_activity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 log_name = login_name.getText().toString();
                String passw = login_password.getText().toString();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("DETAILS");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(log_name))
                        {
                            if(log_name.isEmpty()){
                                Toast.makeText(login_activity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                DataSnapshot ds = snapshot.child(log_name);
                                UserInfo userInfo = ds.getValue(UserInfo.class);
                                String pw = userInfo.getPassword();


                                if(pw.equals(passw)) {
                                    Toast.makeText(login_activity.this, "Welcome " + log_name, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(login_activity.this, home_activity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(login_activity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }else{
                            Toast.makeText(login_activity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });



    }
    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage((CharSequence) "Do you want to exit?").setCancelable(true).setPositiveButton((CharSequence) "yes",
                (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialogInterface, int i) {
                        login_activity.this.finishAffinity();
                    }
                }).setNegativeButton((CharSequence) "no", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();

    }
}