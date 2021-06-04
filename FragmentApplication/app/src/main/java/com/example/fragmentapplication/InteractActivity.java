package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InteractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact);
    }

    public void onclickCommunicate(View view) {
        TextView txt = (TextView) findViewById(R.id.txt1);
        Toast.makeText(this, txt.getText().toString() + "f1", Toast.LENGTH_SHORT).show();
    }
}