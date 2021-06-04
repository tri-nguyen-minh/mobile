package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private final String ADD_ACTION = "Add";
    private final String SUBTRACT_ACTION = "Subtract";
    private final String MULTIPLY_ACTION = "Multiply";
    private final String DIVIDE_ACTION = "Divide";
    private final String NUMBER_1 = "num1";
    private final String NUMBER_2 = "num2";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        intent = this.getIntent();
        Double num1 = Double.parseDouble(intent.getStringExtra(NUMBER_1));
        Double num2 = Double.parseDouble(intent.getStringExtra(NUMBER_2));
        Double result = 0.0;
        TextView view = (TextView)findViewById(R.id.txtResult);

        if(ADD_ACTION.equals(intent.getAction())) {

            result = num1 + num2;

        } else if (SUBTRACT_ACTION.equals(intent.getAction())) {

            result = num1-num2;

        } else if (MULTIPLY_ACTION.equals(intent.getAction())) {

            result = num1*num2;

        } else if (DIVIDE_ACTION.equals(intent.getAction())) {

            result = num1/num2;

        }

        view.setText(result.toString());

    }

    public void onClickBtnBack(View view) {
        finish();
    }
}