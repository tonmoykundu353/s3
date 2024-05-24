package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class show_writers extends AppCompatActivity {

    TextView t1,t2;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_writers);

        index = scinece_books.indx;

        t1 = findViewById(R.id.book_name);
        t2 = findViewById(R.id.author_name);

        t1.setText(scinece_books.books.get(index));
        t2.setText(scinece_books.writers.get(index));

    }
}