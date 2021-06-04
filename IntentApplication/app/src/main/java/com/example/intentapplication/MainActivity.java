package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private final String GOOGLE_LINK = "https://www.google.com.vn";
    private final String TEL = "tel:0947009497";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBtnAddActivity(View view) {

        intent =  new Intent(this, CalculatingActivity.class);
        startActivity(intent);
    }

    public void onClickBtnStartBrowser(View view) {
        Uri uri = Uri.parse(GOOGLE_LINK);
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickBtnStartBrowserLaunch(View view) {
        Uri uri = Uri.parse(GOOGLE_LINK);
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickBtnStartPhone(View view) {
        Uri uri = Uri.parse(TEL);
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickBtnException(View view) {
        Uri uri = Uri.parse(GOOGLE_LINK);
        intent = new Intent("sample.intent.intentdemo.LAUNCH", uri);
        startActivity(intent);
    }


    public void onClicksendSMS(View view) {
    }
}