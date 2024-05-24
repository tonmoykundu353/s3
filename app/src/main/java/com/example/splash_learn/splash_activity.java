package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splash_activity extends AppCompatActivity {

    LottieAnimationView education;

    Animation topAnimation,bottomAnimation;
    ImageView imageView;
    TextView app_name;
    Button login;

    private static int Delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        education = findViewById(R.id.education);
        app_name = findViewById(R.id.app_name);

        education.setAnimation(topAnimation);
        app_name.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_activity.this, slider_activity.class);
                Intent intent1 = new Intent(splash_activity.this, login_activity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair(education,"splash_image");
                pairs[1] = new Pair(app_name,"splash_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(splash_activity.this,pairs);
                final String PREFS_NAME = "MyPrefsFile";

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);




                if (settings.getBoolean("my_first_time", true)) {

                    startActivity(intent,options.toBundle());
                    settings.edit().putBoolean("my_first_time", false).commit();
                }
                else{
                    startActivity(intent1);
                }

                finish();

            }
        },Delay);
        ImageView splash_upper_shape,splash_lower_shape;

        splash_upper_shape = findViewById(R.id.splash_upper_shape);
        splash_lower_shape = findViewById(R.id.splash_lower_shape);

        Animation my_animation1 = AnimationUtils.loadAnimation(splash_activity.this,R.anim.animation1);
        app_name.setAnimation(my_animation1);

        splash_upper_shape.startAnimation(my_animation1);
        splash_lower_shape.startAnimation(my_animation1);



    }
}