package com.example.splash_learn;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;

public class home_fragment extends Fragment {

    GridLayout mainGrid;
    TextView t2;
    ImageView img1;

    public home_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        mainGrid = view.findViewById(R.id.mainGrid);
        t2 = view.findViewById(R.id.textGrid);
        img1 = view.findViewById(R.id.clg_imageView);

        setSingleEvent(mainGrid);
        //

// Load the animation resource
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_transition);

// Create a LayoutAnimationController and set the animation
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
        mainGrid.setLayoutAnimation(layoutAnimationController);
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.animation3);
        LayoutAnimationController layoutAnimationController1 = new LayoutAnimationController(animation1);
        t2.startAnimation(animation);
        img1.startAnimation(animation1);


// Start the animation
        mainGrid.startLayoutAnimation();
        //


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference = databaseReference.child("DETAILS").child(login_activity.log_name).child("cap");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot event : snapshot.getChildren()){
                    String s = event.getValue().toString();
                    if(!s.isEmpty()) {
                        vars.cap.add(s);
                        Log.d("trr", s);
                        //Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference();
        databaseReference1 = databaseReference1.child("DETAILS").child(login_activity.log_name).child("url");
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot event : snapshot.getChildren()){
                    String s = event.getValue().toString();
                    if(!s.isEmpty()) {
                        vars.url_list.add(s);
                        Log.d("trr", s);
                        //Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         return view;


    }
    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Intent intent = new Intent(getActivity(),Activity2.class);
                    intent.putExtra("info",""+finalI);
                    startActivity(intent);

                }
            });
        }
    }
}