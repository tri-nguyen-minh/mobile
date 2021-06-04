package com.example.dynamicinterfaceapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dto.RowTopicAdapter;
import com.example.dto.RowTopicItem;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerActivity extends AppCompatActivity {

    private List<RowTopicItem> items;
    private RowTopicAdapter adapter;
    private CharSequence mTopic;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle toggle;
    private String[] menuTitles = {"ktk", "facebook"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mTopic = getTitle();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        listView = (ListView)findViewById(R.id.sliderList);
        items = new ArrayList<>();

        for (int i = 0; i < menuTitles.length; i++) {
            RowTopicItem item = new RowTopicItem(menuTitles[i]);
            items.add(item);
        }
        adapter = new RowTopicAdapter(getApplicationContext(), items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateDisplay(position);
            }
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mTopic);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle(mTopic);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(toggle);
        if(savedInstanceState == null) {
            updateDisplay(0);
        }
    }

    private void updateDisplay(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new KTKActivity();
            case 1:
                fragment = new FacebookActivity();
            default:
                break;
        }
        if (fragment != null) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.frame_container, fragment)
                    .commit();
            setTitle(mTopic);
            drawerLayout.closeDrawer(listView);
        } else {
            Log.e("MainActivity", "Creating fragment error");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTopic = title;
        getActionBar().setTitle(mTopic);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId()==0) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
}