package com.example.dto;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabapplication.CalculatorFragment;
import com.example.tabapplication.HistoryFragment;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CalculatorFragment calculatorFragment = new CalculatorFragment();
                return calculatorFragment;
            case 1:
                HistoryFragment historyFragment = new HistoryFragment();
                return historyFragment;
//            case 2:
//                NBA nbaFragment = new NBA();
//                return nbaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
