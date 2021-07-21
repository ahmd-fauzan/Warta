package com.ppb.warta;


import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;



public class WebActivity extends AppCompatActivity {

    WebView webView;

    @Override
    public void onBackPressed() {
        if (webView.canGoBack( )) {
            webView.goBack( );
            webView.goBack( );
        } else {
            super.onBackPressed( );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView=findViewById(R.id.web_view);

        Intent intent=getIntent();
        String webSite=intent.getStringExtra("Web");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(webSite);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}
