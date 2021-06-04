package com.example.registrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    private TextView viewEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view);

        Intent intent = getIntent();
        Bundle info = intent.getBundleExtra("INFO");

        viewEdit = (TextView)findViewById(R.id.txtUsername);
        viewEdit.setText(info.getString("username"));
        viewEdit = (TextView)findViewById(R.id.txtPass);
        viewEdit.setText(info.getString("password"));
        viewEdit = (TextView)findViewById(R.id.txtFull);
        viewEdit.setText(info.getString("full"));
        viewEdit = (TextView)findViewById(R.id.txtGender);
        viewEdit.setText(info.getString("gender"));
        viewEdit = (TextView)findViewById(R.id.txtStatus);
        viewEdit.setText(info.getString("status"));
        viewEdit = (TextView)findViewById(R.id.txtBirthday);
        viewEdit.setText(info.getString("birthday"));
        viewEdit = (TextView)findViewById(R.id.txtNationality);
        viewEdit.setText(info.getString("nationality"));
        viewEdit = (TextView)findViewById(R.id.txtExperience);
        viewEdit.setText(info.getInt("EXP") + " year(s)");
        viewEdit = (TextView)findViewById(R.id.txtJava);
        viewEdit.setText(info.getString("JV"));
        viewEdit = (TextView)findViewById(R.id.txtRating);
        viewEdit.setText(String.valueOf(info.getFloat("rating")));

        NumberPicker nbYear = (NumberPicker)findViewById(R.id.nbpYear);
        nbYear.setMaxValue(10);
        nbYear.setMinValue(1);
        nbYear.setWrapSelectorWheel(false);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_layout));

        TextView txtResult = (TextView)layout.findViewById(R.id.txtYear);
        txtResult.setText("Please Review your Information");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 0);
        toast.setView(layout);
        toast.show();
    }

    public void onclickBack(View view) {
        finish();
    }

    public void onclickConfirm(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_layout));

        TextView txtResult = (TextView)layout.findViewById(R.id.txtYear);
        NumberPicker nbpYear = (NumberPicker)findViewById(R.id.nbpYear);

        String confirmMessage = "Thank you for your Registration\nYour Registration will expire in "
                + String.valueOf(nbpYear.getValue()) + " year(s)";
        txtResult.setText(confirmMessage);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        Button confirm = (Button)findViewById(R.id.btnConfirm);
        confirm.setEnabled(false);

    }

    public void onclickViewWebsite(View view) {
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        startActivity(intent);
    }
}