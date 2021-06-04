package com.example.dto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dynamicinterfaceapplication.R;

import java.util.List;

public class RowTopicAdapter extends BaseAdapter {

    private Context context;
    private List<RowTopicItem> items;

    public RowTopicAdapter(Context context, List<RowTopicItem> items) {
        super();
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.indexOf(items.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_list_item, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.txtTopic);
        RowTopicItem item = items.get(position);
        textView.setText(item.getTopic());
        return convertView;
    }
}
