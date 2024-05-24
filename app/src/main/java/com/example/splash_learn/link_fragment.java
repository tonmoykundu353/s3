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
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class link_fragment extends Fragment {


    GridLayout mainGrid;
    TextView t1,t2;
    ImageView img1;


    public link_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_link_fragment, container, false);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.float_btn);
        mainGrid = view.findViewById(R.id.mainGrid1);
        t1 = view.findViewById(R.id.textGrid3);
        t2 = view.findViewById(R.id.textGrid4);
        img1 = view.findViewById(R.id.link_imageView);
        setSingleEvent(mainGrid);
        //


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "lkdgjalkdfj", Toast.LENGTH_SHORT).show();
                fshowBottomSheetDialog();
            }
        });
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

        // Inflate the layout for this fragment
        return view;
    }
    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),links_webview.class);
                    intent.putExtra("info",""+finalI);
                    startActivity(intent);

                }
            });
        }
    }

    private void fshowBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(R.layout.bottomsheet);

        EditText editText = bottomSheetDialog.findViewById(R.id.chan_name);
        EditText editText1 = bottomSheetDialog.findViewById(R.id.url);
        Button button = bottomSheetDialog.findViewById(R.id.addTask);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chan_name = editText.getText().toString();
                String url = editText1.getText().toString();
                if(!(chan_name.isEmpty() || url.isEmpty())) vars.aBoolean = true;
                Intent intent = new Intent(getActivity(), New_link.class);
                intent.putExtra("chan_name",chan_name);
                intent.putExtra("url",url);
                String s = login_activity.log_name;
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference = databaseReference.child("DETAILS").child(s);
                int i = vars.cap.size();
                databaseReference.child("cap").child(""+i).setValue(chan_name);

                DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference();
                databaseReference1 = databaseReference1.child("DETAILS").child(s);
                int j = vars.cap.size();
                databaseReference1.child("url").child(""+j).setValue(url);

                startActivity(intent);
            }
        });

        bottomSheetDialog.show();

    }
}