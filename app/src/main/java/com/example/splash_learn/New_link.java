package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class New_link extends AppCompatActivity {
//    public static ArrayList<String> cap = new ArrayList<>();
//    public static ArrayList<String> url_list= new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_link);
        if(vars.aBoolean) {
            Intent intent = getIntent();
            String chan_name = intent.getStringExtra("chan_name");
            vars.cap.add(chan_name);
            String url = intent.getStringExtra("url");
            vars.url_list.add(url);
        }
        vars.aBoolean = false;


        listView = findViewById(R.id.list_view);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, vars.cap);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(New_link.this, fetch_links.class);
                intent1.putExtra("rep", vars.url_list.get(position));
                startActivity(intent1);


            }

        }
    );


    }


}