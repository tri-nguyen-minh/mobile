package com.example.dynamicinterfaceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UIProgrammingActivity extends AppCompatActivity {

    private EditText editText;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ui_programming);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView txtView = new TextView(this);
        txtView.setTextSize(18);
        txtView.setText("Enter something: ");
        txtView.setLayoutParams(params);

        editText = new EditText(this);
        editText.setTextSize(18);
        editText.setId(R.string.txt_id);
        editText.setLayoutParams(params);

        Button btn = new Button(this);
        btn.setLayoutParams(params);
        btn.setText("View Input");

        Button btnBack = new Button(this);
        btnBack.setLayoutParams(params);
        btnBack.setText("Back");

        linear.addView(txtView);
        linear.addView(editText);
        linear.addView(btn);
        linear.addView(btnBack);

        this.addContentView(linear, params);

        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                editText = (EditText)findViewById(R.string.txt_id);
                if (editText.getText() == null) {
                    Toast.makeText(getApplicationContext(), "Enter Something", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}