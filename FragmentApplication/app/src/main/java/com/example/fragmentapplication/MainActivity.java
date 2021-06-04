package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            System.out.println("NULL");
            getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).commit();
        } else {
            System.out.println("NOT NULL");
        }
    }

    public void onClickBtnDynamic(View view) {
        intent = new Intent(this, DynamicActivity.class);
        startActivity(intent);
    }

    public void onClickBtnInteract(View view) {
        intent = new Intent(this, InteractActivity.class);
        startActivity(intent);
    }
}