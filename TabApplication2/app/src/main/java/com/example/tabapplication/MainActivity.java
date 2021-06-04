package com.example.tabapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dto.MyAdapter;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final String HEADER = "Calculation Result\n";
    private final String EMPTY_ERROR = "Please enter both Numbers";
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Calculator"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void onClickBtnAdd(View view) {
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView result = (TextView)findViewById(R.id.txtResult);
        String output = HEADER;
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            Double d1 = Double.parseDouble(num1.getText().toString());
            Double d2 = Double.parseDouble(num2.getText().toString());

            String equation = d1 + " + " + d2 + " = " + (d1 + d2);

            output += equation;

            result.setText(output);
            TextView history = (TextView)findViewById(R.id.txtHistory);
            String currentHistory = history.getText().toString();
            System.out.println("a: "+currentHistory);
            history.setText((currentHistory.isEmpty()) ? equation : (currentHistory + "\n" + equation));

        }
        else {
            error = output + EMPTY_ERROR;
            result.setText(error);
        }
    }

    public void onClickBtnSubtract(View view) {
//        intent =  new Intent(this, ResultActivity.class);
        EditText num1 = (EditText)findViewById(R.id.editNum1);
        EditText num2 = (EditText)findViewById(R.id.editNum2);
        TextView result = (TextView)findViewById(R.id.txtResult);
        String output = HEADER;
        String error = "";
        if(!isInvalidNumber(num1, num2)) {
            Double d1 = Double.parseDouble(num1.getText().toString());
            Double d2 = Double.parseDouble(num2.getText().toString());

            String equation = d1 + " - " + d2 + " = " + (d1 - d2);

            output += equation;

            result.setText(output);
            TextView history = (TextView)findViewById(R.id.txtHistory);
            String currentHistory = history.getText().toString();
            history.setText((currentHistory.isEmpty()) ? equation : (currentHistory + "\n" + equation));
        }
        else {
            error = output + EMPTY_ERROR;
            result.setText(error);
        }
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