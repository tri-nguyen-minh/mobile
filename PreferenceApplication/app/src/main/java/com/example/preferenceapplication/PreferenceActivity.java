package com.example.preferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.RingtonePreference;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {

    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
    }

    public void onBtnLoadClick(View view) {
        startActivity(new Intent("com.example.preferenceapplication.MyPreferenceActivity"));
    }

    public void onBtnDisplayClick(View view) {
        SharedPreferences sharedPreferences =
                getSharedPreferences("myAppPreferences", MODE_PRIVATE);
        Toast.makeText(getBaseContext(),
                sharedPreferences.getString("editTextPref", ""), Toast.LENGTH_LONG).show();
        System.out.println(sharedPreferences.getString("editTextPref", ""));
    }

    public void onBtnModifyClick(View view) {
        SharedPreferences sharedPreferences =
                getSharedPreferences("myAppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText txt = (EditText)findViewById(R.id.editText);
        editor.putString("editTextPref", txt.getText().toString());
        editor.commit();
    }


}