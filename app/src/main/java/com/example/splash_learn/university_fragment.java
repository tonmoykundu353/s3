package com.example.splash_learn;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class university_fragment extends Fragment {


    GridLayout mainGrid;
    TextView t1,t2;
    ImageView img1;


    public university_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_university_fragment, container, false);
        mainGrid = view.findViewById(R.id.mainGrid);
        t1 = view.findViewById(R.id.textGrid1);
        t2 = view.findViewById(R.id.textGrid2);
        img1 = view.findViewById(R.id.uni_imageView);
        setSingleEvent(mainGrid);
        //

// Load the animation resource
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_transition);
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.animation3);

// Create a LayoutAnimationController and set the animation
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
        LayoutAnimationController layoutAnimationController1 = new LayoutAnimationController(animation1);
        mainGrid.setLayoutAnimation(layoutAnimationController);
        t1.startAnimation(animation);
        t2.startAnimation(animation);
        img1.startAnimation(animation1);

// Start the animation
        mainGrid.startLayoutAnimation();
        //
        return view;


    }
    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),university_webview.class);
                    intent.putExtra("info",""+finalI);
                    startActivity(intent);

                }
            });
        }
    }
}