package com.example.dynamicinterfaceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        System.out.println("Width: " + width + "\nHeight: " + height);
        if(width > height) {
            Toast.makeText(this, "Screen switched to Landscape mode", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Screen switched to Portrait mode", Toast.LENGTH_LONG).show();
        }
    }

    public void onAnchorClick(View view) {
        startActivity(new Intent(this, AnchorActivity.class));
    }

    public void onManualClick(View view) {
        startActivity(new Intent(this, ManualActivity.class));
    }

    public void onChangeOrientationCLick(View view) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public void onCreateUICLick(View view) {
        startActivity(new Intent(this, UIProgrammingActivity.class));
    }

    public void onFlipperClick(View view) {
        startActivity(new Intent(this, ViewFlipperActivity.class));
    }

    public void onSlideClick(View view) {
        startActivity(new Intent(this, SlidingDrawerActivity.class));
    }

    public void onNavigateCligk(View view) {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }
}