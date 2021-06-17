package com.example.pictureapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {

    private int step;
    private ImageView img;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        step = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
                img = (ImageView)findViewById(R.id.imgView);
//        Gallery gal = (Gallery)findViewById(R.id.galery1);
//        gal.setAdapter(new ImageAdapter(this, imageIDs));
//        gal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getBaseContext(), "Picture " + (position + 1), Toast.LENGTH_SHORT).show();
//                ImageView img = (ImageView)findViewById(R.id.imgView);
//                img.setBackgroundResource(imageIDs[position]);
//                System.out.println(position);
//            }
//        });
                img.setBackgroundResource(imageIDs[step]);
    }

    public void previous(View view) {
        step--;
        if (step < 0) {
            step = (imageIDs.length - 1);
        }
        img.setBackgroundResource(imageIDs[step]);
    }

    public void next(View view) {
        step++;
        if (step == imageIDs.length) {
            step = 0;
        }
        img.setBackgroundResource(imageIDs[step]);
    }
}

