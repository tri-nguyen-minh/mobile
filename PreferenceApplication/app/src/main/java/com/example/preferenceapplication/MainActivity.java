package com.example.preferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnAccessClick(View view) {
        startActivity(new Intent(this, PreferenceActivity.class));
    }

    public void onBtnSaveClick(View view) {
        startActivity(new Intent(this, SaveActivity.class));
    }

}