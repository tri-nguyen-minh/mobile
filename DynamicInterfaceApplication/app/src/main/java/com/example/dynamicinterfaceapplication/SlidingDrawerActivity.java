package com.example.dynamicinterfaceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextView;

public class SlidingDrawerActivity extends AppCompatActivity {

    private boolean status;
    private SlidingDrawer sliding;
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = true;
        setContentView(R.layout.activity_sliding_drawer);
    }

    public void onHorizontalClick(View view) {
        setContentView(R.layout.fragment_horizontal);
    }

    public void onDirectionClick(View view) {
        if(status) {
            sliding = (SlidingDrawer)findViewById(R.id.sliding);
            sliding.setRotation(180);
            textView = (TextView)findViewById(R.id.txt3);
            textView.setRotation(180);
            btn = (Button)findViewById(R.id.btnHandle1);
            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnMain1);
            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnMain2);
            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnMain3);
            btn.setRotation(180);
            status = false;
        } else {
            sliding = (SlidingDrawer)findViewById(R.id.sliding);
            sliding.setRotation(0);
            textView = (TextView)findViewById(R.id.txt3);
            textView.setRotation(0);
            btn = (Button)findViewById(R.id.btnHandle1);
            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnMain1);
            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnMain2);
            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnMain3);
            btn.setRotation(0);
            status = true;
        }
    }

    public void onHorizontal1Click(View view) {
        if(status) {
            sliding = (SlidingDrawer)findViewById(R.id.slidingH);
            sliding.setRotation(180);
            textView = (TextView)findViewById(R.id.txt3);
            textView.setRotation(180);
//            btn = (Button)findViewById(R.id.btnHandle2);
//            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnHorizontal1);
            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnHorizontal2);
            btn.setRotation(180);
            btn = (Button)findViewById(R.id.btnHorizontal3);
            btn.setRotation(180);
            status = false;
        } else {
            sliding = (SlidingDrawer)findViewById(R.id.sliding);
            sliding.setRotation(0);
            textView = (TextView)findViewById(R.id.txt3);
            textView.setRotation(0);
//            btn = (Button)findViewById(R.id.btnHandle2);
//            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnHorizontal1);
            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnHorizontal2);
            btn.setRotation(0);
            btn = (Button)findViewById(R.id.btnHorizontal3);
            btn.setRotation(0);
            status = true;
        }
    }
}