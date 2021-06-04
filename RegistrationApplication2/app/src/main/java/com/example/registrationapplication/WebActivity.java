package com.example.registrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_web_view);

        WebView webView = (WebView)findViewById(R.id.viewWeb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.kieutrongkhanh.net");
    }
}