package com.example.fragmentapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DynamicFragment1 extends Fragment {

    private final String DYNAMIC_1 = "Dynamic 1";

    public DynamicFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(DYNAMIC_1, "onCreateView invoked!");
        return inflater.inflate(R.layout.fragment_dynamic1, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(DYNAMIC_1, "onAttach invoked!");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(DYNAMIC_1, "onCreate invoked!");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(DYNAMIC_1, "onActivityCreate invoked!");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(DYNAMIC_1, "onStart invoked!");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(DYNAMIC_1, "onResume invoked!");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(DYNAMIC_1, "onStop invoked!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(DYNAMIC_1, "onDestroy invoked!");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(DYNAMIC_1, "onDestroyView invoked!");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(DYNAMIC_1, "onDetach invoked!");
    }
}