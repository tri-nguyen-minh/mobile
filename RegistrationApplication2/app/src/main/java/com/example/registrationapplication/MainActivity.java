package com.example.registrationapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String NOT_ANNOUNCE = "N/A";
    private final int DATE_PICKER = 1;
    private final int DATE_RESULT = 2;
    private Spinner spnNationality;
    private String selectedSpinner;
    private TextView txtBirth;
    private int day;
    private int month;
    private int year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        spnNationality = (Spinner) findViewById(R.id.spnNationality);
        List<String> dataSpinner = new ArrayList<>();
        dataSpinner.add("Vietnam");
        dataSpinner.add("Japan");
        dataSpinner.add("China");
        dataSpinner.add("United States");
        dataSpinner.add("United Kingdom");
        dataSpinner.add("Others");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSpinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNationality.setAdapter(dataAdapter);
        spnNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSpinner = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Calendar cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR) - 20;
        txtBirth = (TextView)findViewById(R.id.inputBirthday);
        txtBirth.setText(day + "/" + month + "/" + year);
    }

    public void onclickChkMale(View view) {
        CheckBox chkMale = (CheckBox)findViewById(R.id.chkMale);
        CheckBox chkFemale = (CheckBox)findViewById(R.id.chkFemale);
        if (chkMale.isChecked()) {
            chkFemale.setChecked(false);
        }
    }

    public void onclickChkFemale(View view) {
        CheckBox chkMale = (CheckBox)findViewById(R.id.chkMale);
        CheckBox chkFemale = (CheckBox)findViewById(R.id.chkFemale);
        if (chkFemale.isChecked()) {
            chkMale.setChecked(false);
        }
    }

    public void onclickChangeDate(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("day", day);
        bundle.putInt("month", month);
        System.out.println("in: "+month);
        bundle.putInt("year", year);
        Intent intent = new Intent(this, DateActivity.class);
        intent.putExtra("date", bundle);
        startActivityForResult(intent, DATE_PICKER);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DATE_PICKER) {
            if (resultCode == DATE_RESULT) {
                Bundle bundle = data.getBundleExtra("date");
                day = bundle.getInt("day");
                month = bundle.getInt("month");
                year = bundle.getInt("year");
                System.out.println("from Result: " + month);
                String result = ((day < 10) ? ("0" + day) : day) + "/"
                        + ((month < 10) ? ("0" + month) : month) + "/" + year;
                TextView birthday = (TextView)findViewById(R.id.inputBirthday);
                birthday.setText(result);
            }
        }
    }

    public void onclickRegister(View view) {
        Bundle bundle = new Bundle();

        EditText username = (EditText) findViewById(R.id.editUsername);
        bundle.putString("username", username.getText().toString().isEmpty() ? NOT_ANNOUNCE : username.getText().toString());

        EditText pass = (EditText) findViewById(R.id.editPass);
        bundle.putString("password", pass.getText().toString().isEmpty() ? NOT_ANNOUNCE : pass.getText().toString());

        EditText fullname = (EditText) findViewById(R.id.editFull);
        bundle.putString("full", fullname.getText().toString().isEmpty() ? NOT_ANNOUNCE : fullname.getText().toString());

        CheckBox chkMale = (CheckBox)findViewById(R.id.chkMale);
        CheckBox chkFemale = (CheckBox)findViewById(R.id.chkFemale);

        if (!chkMale.isChecked() && !chkFemale.isChecked()) {
            bundle.putString("gender", NOT_ANNOUNCE);
        } else if (chkFemale.isChecked()) {
            bundle.putString("gender", "Female");
        } else {
            bundle.putString("gender", "Male");
        }
        RadioGroup rdoG = (RadioGroup)findViewById(R.id.rdoStatus);
        int checkedItemId = rdoG.getCheckedRadioButtonId();
        if(checkedItemId < 0) {
            bundle.putString("status", NOT_ANNOUNCE);
        } else {
            RadioButton rdoBtn = (RadioButton)findViewById(checkedItemId);
            bundle.putString("status", rdoBtn.getText().toString());
        }
        TextView birthday = (TextView)findViewById(R.id.inputBirthday);
        bundle.putString("birthday", birthday.getText().toString());

        bundle.putString("nationality", selectedSpinner);

        SeekBar sbEXP = (SeekBar)findViewById(R.id.skbExp);
        bundle.putInt("EXP", sbEXP.getProgress());

        ToggleButton tgJV = (ToggleButton)findViewById(R.id.tglJava);
        bundle.putString("JV", tgJV.getText().toString());

        RatingBar rating = (RatingBar)findViewById(R.id.rating);
        bundle.putFloat("rating", rating.getRating());

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("INFO", bundle);
        startActivity(intent);
    }
}