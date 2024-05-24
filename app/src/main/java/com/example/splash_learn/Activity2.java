package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        im = findViewById(R.id.imageView2);



        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            switch(info){
                case "0":
                    im.setImageResource(R.drawable.pele);
                    txtInfo.setText(R.string.pele);
                    break;
                case "1":
                    im.setImageResource(R.drawable.muhammad_ali);
                    txtInfo.setText(R.string.ali);
                    break;
                case "2":
                    im.setImageResource(R.drawable.apg);
                    txtInfo.setText(R.string.apj);
                    break;
                case "3":
                    im.setImageResource(R.drawable.mark);
                    txtInfo.setText(R.string.mark);
                    break;
                case "4":
                    im.setImageResource(R.drawable.jordan);
                    txtInfo.setText(R.string.jordan);
                    break;
                case "5":
                    im.setImageResource(R.drawable.swami);
                    txtInfo.setText(R.string.swami);
                    break;
                case "6":
                    im.setImageResource(R.drawable.martin_luther_king);
                    txtInfo.setText(R.string.martin);
                    break;
                case "7":
                    im.setImageResource(R.drawable.socrates);
                    txtInfo.setText(R.string.socrates);
                    break;
                case "8":
                    im.setImageResource(R.drawable.ratan_tata);
                    txtInfo.setText(R.string.ratan);
                    break;
                case "9":
                    im.setImageResource(R.drawable.elon);
                    txtInfo.setText(R.string.elon);
                    break;
                case "10":
                    im.setImageResource(R.drawable.steve_wozniak);
                    txtInfo.setText(R.string.steve);
                    break;
                case "11":
                    im.setImageResource(R.drawable.confucius);
                    txtInfo.setText(R.string.confucius);
                    break;


            }
        }
    }
}