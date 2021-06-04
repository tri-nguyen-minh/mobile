package com.example.activityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class InputActivity extends AppCompatActivity {

    private final String DISPLAY_OUTPUT = "Your name is ";
    private final String RESULT = "name";
    private final int RESULT_OK = 2;
    private final int RESULT_EMPTY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    private String getInputValue() {
        EditText inputText = (EditText)findViewById(R.id.editInputText);
        return inputText.getText().toString();
    }

    public void onClickBtnInput(View view) {
        String input = getInputValue();
        String output = "";
        TextView mView = (TextView)findViewById(R.id.lblDisplay);
        if (!input.isEmpty()) {
            System.out.println(output);
            output = DISPLAY_OUTPUT + input;
        }
        mView.setText(output);

    }

    public void onClickBtnDone(View view) {
        String input = getInputValue();
        Intent intent = this.getIntent();
        intent.putExtra(RESULT, input);
        if(!input.isEmpty()) {
            this.setResult(RESULT_OK, intent);
        } else {
            this.setResult(RESULT_EMPTY, intent);
        }
        finish();
    }

}