package com.example.dynamicinterfaceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private Button btnAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        btnAuto = (Button)findViewById(R.id.btnAuto);
        flipperAction();

    }

    public void onPreviousClick (View view) {
        stopFlipperAction();
        flipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out));
        flipper.showPrevious();
    }

    public void onNextClick (View view) {
        stopFlipperAction();
        flipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out));
        flipper.showNext();
    }

    private void flipperAction() {
        flipper.setAutoStart(true);
        flipper.setFlipInterval(2000);
        flipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out));
        flipper.startFlipping();
        btnAuto.setText("Stop");
    }

    private void stopFlipperAction() {
        flipper.stopFlipping();
        btnAuto.setText("Auto");
    }

    public void onAutoClick(View view) {
        String txt = btnAuto.getText().toString();
        if (txt.equals("Auto")) {
            flipperAction();
        } else {
            stopFlipperAction();
        }
    }
}