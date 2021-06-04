package com.example.pictureapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private Integer[] imageIDs = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
    };
    private ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        switcher = (ImageSwitcher)findViewById(R.id.imgSwitch);
        switcher.setFactory(this);
        switcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        switcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        Gallery gal = (Gallery)findViewById(R.id.galery2);
        gal.setAdapter(new ImageAdapter(this, imageIDs));
        gal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Picture " + (position + 1), Toast.LENGTH_SHORT).show();
                switcher.setImageResource(imageIDs[position]);
            }
        });
    }

    @Override
    public View makeView() {
        ImageView imgView = new ImageView(this);
        imgView.setBackgroundColor(0xFF000000);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        return imgView;
    }
}