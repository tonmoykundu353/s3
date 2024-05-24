package com.example.splash_learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoiceBoxOrganizerActivity extends AppCompatActivity {

    Button gotoorganizeeventbtn,gotoshowStudentbtn;
    String UserRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choice_box_organizer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.organizer_login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        UserRoll=getIntent().getStringExtra("UserRoll");
        gotoorganizeeventbtn=findViewById(R.id.goto_organize_event_btn);
        gotoshowStudentbtn=findViewById(R.id.goto_show_student_list);

        gotoorganizeeventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoiceBoxOrganizerActivity.this, OrganizerActivity.class);
                intent.putExtra("UserRoll",UserRoll);
                startActivity(intent);
            }
        });


        gotoshowStudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoiceBoxOrganizerActivity.this, RegisteredStudentEtEventActivity.class);
                intent.putExtra("UserRoll",UserRoll);
                startActivity(intent);
            }
        });
    }
}