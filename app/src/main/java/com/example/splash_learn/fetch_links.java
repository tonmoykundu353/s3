package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class fetch_links extends AppCompatActivity {

    WebView link_webview;
    ProgressBar pgbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_links);
        link_webview = findViewById(R.id.nlink_webview);
        link_webview.getSettings().setJavaScriptEnabled(true);
        link_webview.getSettings().setDomStorageEnabled(true);
        pgbar1 = findViewById(R.id.npgbar1);
        Intent intent =  getIntent();
       String s= intent.getStringExtra("rep");
        Toast.makeText(fetch_links.this, s, Toast.LENGTH_SHORT).show();
        link_webview.loadUrl(s);
        rest_work();

    }

    public void rest_work() {
        link_webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgbar1.setVisibility(View.VISIBLE );
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgbar1.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

    }
}