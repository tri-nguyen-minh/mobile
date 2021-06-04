package com.example.uinotificationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UIListeningActivity extends AppCompatActivity {

    private Button btn;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getBaseContext(), ((Button)v).getText() + " was clicked",
                            Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_listening);

        btn = (Button)findViewById(R.id.btnOk);
        btn.setOnClickListener(onClickListener);
        btn = (Button)findViewById(R.id.btnCancel);
        btn.setOnClickListener(onClickListener);

        EditText txtName = (EditText)findViewById(R.id.txtName);
        txtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(getBaseContext(), "EditName has focus",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getBaseContext(), "Center was clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getBaseContext(), "Left was clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Toast.makeText(getBaseContext(), "Right was clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getBaseContext(), "Up was clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getBaseContext(), "Down was clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }
}