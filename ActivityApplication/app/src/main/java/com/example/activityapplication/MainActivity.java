package com.example.activityapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final String DEFAULT_DISPLAY = "Please input your Name";
    private final String RESULT = "name";
    private final String WELCOME_OUTPUT = "Hello, ";
    private final int INPUT_ACTIVITY = 1;
    private final int RESULT_OK = 2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate is Invoked!");
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnInputName(View view) {
        intent =  new Intent(this, InputActivity.class);
        startActivityForResult(intent, INPUT_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView txtResult = (TextView)findViewById(R.id.txtResult);
        if(requestCode == INPUT_ACTIVITY) {
            String output = "";
            if(resultCode == RESULT_OK) {
                output = WELCOME_OUTPUT + data.getStringExtra(RESULT);
            } else {
                output = DEFAULT_DISPLAY;
            }
            txtResult.setText(output);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart is Invoked!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart is Invoked!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop is Invoked!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause is Invoked!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume is Invoked!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy is Invoked!");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState is Invoked!");
        outState.putString("state", "onStandby");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("onRestoreInstanceState is Invoked!");
        System.out.println("Stored State: " + savedInstanceState.getString("state"));
    }

    public void onClickBtnThemes(View view) {
    }

    public void onClickBtnDialog(View view) {
    }

    public void onClickBtnProgress(View view) {
    }

    public void onClickBtnComplex(View view) {
    }
}
