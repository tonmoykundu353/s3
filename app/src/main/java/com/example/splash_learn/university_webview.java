package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class university_webview extends AppCompatActivity {

    WebView uni_webview;
    ProgressBar pgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_webview);

        uni_webview = findViewById(R.id.uni_webview);
        uni_webview.getSettings().setJavaScriptEnabled(true);
        uni_webview.getSettings().setDomStorageEnabled(true);
        pgbar = findViewById(R.id.pgbar);

        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            switch(info){
                case "0":
                    uni_webview.loadUrl("https://www.du.ac.bd/undergraduatePrograms");
                    rest_work();
                    break;
                case "1":
                    uni_webview.loadUrl("https://admission.ru.ac.bd/");
                    rest_work();
                    break;
                case "2":
                    uni_webview.loadUrl("https://admission.cu.ac.bd/");
                    rest_work();

                    break;
                case "3":
                    uni_webview.loadUrl("https://ku.ac.bd/undergraduate");
                    rest_work();

                    break;
                case "4":
                    uni_webview.loadUrl("https://admission.jnu.ac.bd/");
                    rest_work();

                    break;
                case "5":
                    uni_webview.loadUrl("https://juniv-admission.org/");
                    rest_work();

                    break;
                case "6":
                    uni_webview.loadUrl("https://admission.sust.edu.bd/");
                    rest_work();

                    break;
                case "7":
                    uni_webview.loadUrl("https://www.iu.ac.bd/index.php/site/notice/Mg==");
                    rest_work();

                    break;
                case "8":

                    break;
                case "9":

                case "10":

                    break;
                case "11":

                    break;
                case "12":

                    break;


            }
        }

    }

    public void rest_work() {
        uni_webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgbar.setVisibility(View.VISIBLE );
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgbar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(uni_webview.canGoBack())
        {
            uni_webview.goBack();
        }else
        {
            super.onBackPressed();
        }

    }
}