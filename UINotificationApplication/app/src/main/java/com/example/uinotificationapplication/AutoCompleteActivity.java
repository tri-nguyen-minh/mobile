package com.example.uinotificationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private String[] suggestion = {"trinm","Tri Nguyen", "Nguyen Tri",
                                    "Tri Minh Nguyen", "Nguyen Minh Tri",
                                    "Advance Java", "XML", "Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, suggestion);

        AutoCompleteTextView txt = (AutoCompleteTextView)findViewById(R.id.txtInput);
        txt.setThreshold(3);
        txt.setAdapter(adapter);
    }

    public void onAutoBack(View view) {
        finish();
    }
}