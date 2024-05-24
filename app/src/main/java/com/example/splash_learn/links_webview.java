package com.example.splash_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class links_webview extends AppCompatActivity {
    WebView link_webview;
    ProgressBar pgbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_webview);
        link_webview = findViewById(R.id.link_webview);
        link_webview.getSettings().setJavaScriptEnabled(true);
        link_webview.getSettings().setDomStorageEnabled(true);
        pgbar1 = findViewById(R.id.pgbar1);

        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            switch(info){
                case "0":
                    link_webview.loadUrl("https://www.youtube.com/@UdvashUnmesh/playlists");
                    rest_work();
                    break;
                case "1":
                    link_webview.loadUrl("https://www.youtube.com/@OnnorokomPathshala/playlists");
                    rest_work();
                    break;
                case "2":
                    link_webview.loadUrl("https://www.youtube.com/@bondipathshala/playlists");
                    rest_work();
                    break;
                case "3":
                    link_webview.loadUrl("https://www.youtube.com/@AparsClassroom/playlists");
                    rest_work();
                    break;
                case "4":
                    link_webview.loadUrl("https://www.youtube.com/@ChinmoysPhysicsSolutions/playlists");
                    rest_work();
                    break;
                case "5":
                    link_webview.loadUrl("https://www.youtube.com/@FahadHossainEdutubebd/playlists");
                    rest_work();
                    break;
                case "6":
                    link_webview.loadUrl("https://www.youtube.com/@SciencePathshalabiggabchinta/playlists");
                    rest_work();
                    break;
                case "7":
                    link_webview.loadUrl("https://www.youtube.com/watch?v=E8lalwsqIrQ&list=PL3j4Nx_lZdVpDZG9c6djr7j0VQZfhu75f");
                    rest_work();
                    break;
                case "8":
                    link_webview.loadUrl("https://www.youtube.com/@alchemy149/playlists");
                    rest_work();
                    break;
                case "9":
                    link_webview.loadUrl("https://www.youtube.com/@HulkenSteinHSC/playlists");
                    rest_work();
                    break;
                    case "10":
                    link_webview.loadUrl("https://www.youtube.com/@apurbophysics/playlists");
                    rest_work();
                    break;
                case "11":
                    link_webview.loadUrl("https://www.youtube.com/@FahadAcademyforBiologyFAB/playlists");
                    rest_work();
                    break;


            }
        }

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

    @Override
    public void onBackPressed() {
        if(link_webview.canGoBack())
        {
            link_webview.goBack();
        }else
        {
            super.onBackPressed();
        }

    }
}
