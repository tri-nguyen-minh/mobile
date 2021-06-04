package com.example.uinotificationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_design);
    }

    public void onAutoClick(View view) {
        startActivity(new Intent(this, AutoCompleteActivity.class));
    }

    public void onDateTimeClick(View view) {
        startActivity(new Intent(this, DateTimeActivity.class));
    }

    public void onListClick(View view) {
        startActivity(new Intent(this, DisplayListActivity.class));
    }

    public void onListMultipleClick(View view) {
        startActivity(new Intent(this, ListMultipleActivity.class));
    }

    public void onSpinnerClick(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }
}