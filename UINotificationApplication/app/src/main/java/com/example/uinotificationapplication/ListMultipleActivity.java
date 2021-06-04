package com.example.uinotificationapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListMultipleActivity extends ListActivity {

    private String[] suggestion = {"trinm","Tri Nguyen", "Nguyen Tri",
            "Tri Minh Nguyen", "Nguyen Minh Tri",
            "Advance Java", "XML", "Others"};

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = getListView();
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setTextFilterEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, suggestion);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getBaseContext(), "Selected: " + suggestion[position], Toast.LENGTH_SHORT).show();
    }
}