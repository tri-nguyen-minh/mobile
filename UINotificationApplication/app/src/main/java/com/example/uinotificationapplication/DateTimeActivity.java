package com.example.uinotificationapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String strDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                Toast.makeText(getBaseContext(), "Date selected: " + strDate,
                        Toast.LENGTH_SHORT).show();
            }
        });
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
                Date date = new Date(0, 0, 0, hourOfDay, minute);
                String time = timeFormat.format(date);
                Toast.makeText(getBaseContext(), "Time selected: " + time,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onDateTimeBack(View view) {
        finish();
    }
}