package com.example.preferenceapplication;

import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.util.Log;

public class MyPreferenceActivity extends PreferenceActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                addPreferencesFromResource(R.xml.preferences);

        SharedPreferences sharedPreferences = getSharedPreferences(
                "com.example.preferenceapplication_preferences",MODE_PRIVATE);
        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
            initSummary(getPreferenceScreen().getPreference(i), sharedPreferences);
        }
        Log.d("create", "onCreate");

//        PreferenceManager manager = getPreferenceManager();
//        manager.setSharedPreferencesName("myAppPreferences");
//
//        addPreferencesFromResource(R.xml.preferences);
//
//        SharedPreferences sharedPreferences =
//                getSharedPreferences("myAppPreferences", MODE_PRIVATE);
//
//        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
//            initSummary(getPreferenceScreen().getPreference(i), sharedPreferences);
//        }
//        Log.d("create", "onCreate");
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePreferences(findPreference(key), sharedPreferences);
    }

    private void updatePreferences(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof EditTextPreference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            preference.setSummary(editTextPreference.getText());
        }
        if (preference instanceof RingtonePreference) {
            RingtonePreference ringtonePreference = (RingtonePreference) preference;
            uri = sharedPreferences.getString(ringtonePreference.getKey(), null);
            if (uri != null) {
                setPreferenceSummary(preference);
            }
            preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference pref, Object newValue) {
                    if (newValue != null && newValue instanceof String) {
                        uri = (String) newValue;
                        setPreferenceSummary(pref);
                    }
                    return false;
                }
            });
        }
    }

    private void initSummary(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof PreferenceCategory) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) preference;
            for (int i = 0; i < preferenceCategory.getPreferenceCount(); i++) {
                initSummary(preferenceCategory.getPreference(i), sharedPreferences);
            }
        } else {
            updatePreferences(preference, sharedPreferences);
        }
    }

    private void setPreferenceSummary(Preference preference) {
        Ringtone ring = RingtoneManager.getRingtone(getApplicationContext(), Uri.parse(uri));
        preference.setSummary(ring.getTitle(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
        Log.d("resume", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
        Log.d("pause", "onPause");
    }
}
