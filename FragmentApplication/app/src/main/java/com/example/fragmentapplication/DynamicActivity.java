package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        WindowManager window = getWindowManager();
        Display display = window.getDefaultDisplay();

        if(display.getWidth() > display.getHeight()) {
            DynamicFragment1 dym1 = new DynamicFragment1();
            transaction.replace(R.id.container, dym1);
        } else {
            DynamicFragment2 dym2 = new DynamicFragment2();
            transaction.replace(R.id.container, dym2);
        }
        transaction.commit();
    }
}