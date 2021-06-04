package com.example.registrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {

    private final int DATE_PICKER = 1;
    private final int DATE_RESULT = 2;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("date");
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        System.out.println("From Bundle: " + bundle.getInt("month"));

        datePicker.updateDate(bundle.getInt("year"), bundle.getInt("month") - 1, bundle.getInt("day"));

    }

    public void onclickBtnBirth(View view) {
        Intent intent = this.getIntent();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        System.out.println("From Picker: " + month);
        Bundle bundle = new Bundle();
        bundle.putInt("day", day);
        bundle.putInt("month", month);
        bundle.putInt("year", year);
        intent.putExtra("date", bundle);
        this.setResult(DATE_RESULT, intent);
        finish();
    }
}