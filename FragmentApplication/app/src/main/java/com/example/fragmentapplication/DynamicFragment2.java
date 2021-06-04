package com.example.fragmentapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicFragment2 extends Fragment {

    public DynamicFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn = (Button)getActivity().findViewById(R.id.btnComm);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView txt = (TextView) getActivity().findViewById(R.id.txtViewDym2);
                Toast.makeText(getActivity(), txt.getText().toString() + "f1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}