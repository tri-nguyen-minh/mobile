package com.example.pictureapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private int itemBackground;
    private Integer[] imageIDs;

    public ImageAdapter() {
    }

    public ImageAdapter(Context context, Integer[] imageIDs) {
        this.imageIDs = imageIDs;
        this.context = context;
        TypedArray arr = context.obtainStyledAttributes(R.styleable.Gallery1);
        itemBackground = arr.getResourceId(R.styleable.Gallery1_android_galleryItemBackground,0);
        arr.recycle();
    }
    @Override
    public int getCount() {
        return this.imageIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = null;
        if(convertView == null) {
            view = new ImageView(context);
            view.setImageResource(imageIDs[position]);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new Gallery.LayoutParams(200, 200));
        } else {
            view = (ImageView)convertView;
        }
        view.setBackgroundResource(itemBackground);
        return view;
    }
}
