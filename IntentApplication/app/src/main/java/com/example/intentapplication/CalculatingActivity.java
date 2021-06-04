package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatingActivity extends AppCompatActivity {

    private final String ADD_ACTION = "Add";
    private final String SUBTRACT_ACTION = "Subtract";
    private final String MULTIPLY_ACTION = "Multiply";
    private final String DIVIDE_ACTION = "Divide";
    private final String EMPTY_ERROR = "Please enter both Numbers";
    private final String DIVIDE_BY_0_ERROR = "Cannot divide by 0";
    private final String NUMBER_1 = "num1";
    private final String NUMBER_2 = "num2";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculating);
    }

    public void onClickBtnAdd(View view) {
        intent =  new Intent(this, ResultActivity.class);
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView txtError = (TextView)findViewById(R.id.txtAddError);
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            System.out.println("in add");
            txtError.setText(error);
            intent.putExtra(NUMBER_1, num1.getText().toString());
            intent.putExtra(NUMBER_2, num2.getText().toString());
            intent.setAction(ADD_ACTION);
            startActivity(intent);
        }
        else {
            error = EMPTY_ERROR;
            txtError.setText(error);
        }
    }

    public void onClickBtnSubtract(View view) {
        intent =  new Intent(this, ResultActivity.class);
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView txtError = (TextView)findViewById(R.id.txtAddError);
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            txtError.setText(error);
            intent.putExtra(NUMBER_1, num1.getText().toString());
            intent.putExtra(NUMBER_2, num2.getText().toString());
            intent.setAction(SUBTRACT_ACTION);
            startActivity(intent);
        }
        else {
            error = EMPTY_ERROR;
            txtError.setText(error);
        }
    }

    public void onClickBtnMultiply(View view) {
        intent =  new Intent(this, ResultActivity.class);
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView txtError = (TextView)findViewById(R.id.txtAddError);
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            txtError.setText(error);
            intent.putExtra(NUMBER_1, num1.getText().toString());
            intent.putExtra(NUMBER_2, num2.getText().toString());
            intent.setAction(MULTIPLY_ACTION);
            startActivity(intent);
        }
        else {
            error = EMPTY_ERROR;
            txtError.setText(error);
        }
    }

    public void onClickBtnDivide(View view) {
        intent =  new Intent(this, ResultActivity.class);
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView txtError = (TextView)findViewById(R.id.txtAddError);
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            if (Double.parseDouble(num2.getText().toString()) == 0) {
                error = DIVIDE_BY_0_ERROR;
                txtError.setText(error);
            } else {
                txtError.setText(error);
                intent.putExtra(NUMBER_1, num1.getText().toString());
                intent.putExtra(NUMBER_2, num2.getText().toString());
                intent.setAction(DIVIDE_ACTION);
                startActivity(intent);
            }

        }
        else {
            error = EMPTY_ERROR;
            txtError.setText(error);
        }
    }

    public void onClickBtnReturnFromAdd(View view) {
        finish();
    }

    private boolean isInvalidNumber(EditText num1, EditText num2) {
        Double number;
        try {
            number = Double.parseDouble(num1.getText().toString());
            number = Double.parseDouble(num2.getText().toString());
        } catch (Exception e) {
            return true;
        }
        return false;
    }

}