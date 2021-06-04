package com.example.pictureapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContext = (Button)findViewById(R.id.btnContext);
        btnContext.setOnCreateContextMenuListener(this);
    }

    public void onShowPicGalClick(View view) {
        startActivity(new Intent(this, GalleryActivity.class));
    }

    public void onSlidePicGalClick(View view) {
        startActivity(new Intent(this, ImageSwitcherActivity.class));
    }

    public void onShowPicGridClick(View view) {
        startActivity(new Intent(this, GridActivity.class));
    }

    public void onClockClick(View view) {
        setContentView(R.layout.activity_clock);
//        startActivity(new Intent(this, ClockActivity.class));
    }

    public void onWebClick(View view) {
        startActivity(new Intent(this, WebActivity.class));
    }

    private void createMenu(Menu menu) {
        menu.setQwertyMode(true);
        MenuItem item1 = menu.add(0, 0, 0, "Iyem 1");
        item1.setAlphabeticShortcut('1');
        item1.setIcon(R.drawable.ic_launcher_foreground);
        MenuItem item2 = menu.add(0, 1, 1, "Iyem 2");
        item2.setAlphabeticShortcut('2');
        item2.setIcon(R.drawable.ic_launcher_foreground);
        MenuItem item3 = menu.add(0, 2, 2, "Iyem 3");
        item3.setAlphabeticShortcut('3');
        item3.setIcon(R.drawable.ic_launcher_foreground);
        MenuItem item4 = menu.add(0, 3, 3, "Iyem 4");
        item4.setAlphabeticShortcut('4');
        item4.setIcon(R.drawable.ic_launcher_foreground);
        MenuItem item5 = menu.add(0, 4, 4, "Iyem 5");
        item5.setAlphabeticShortcut('5');
        item5.setIcon(R.drawable.ic_launcher_foreground);
        MenuItem item6 = menu.add(0, 5, 5, "Iyem 6");
        item1.setAlphabeticShortcut('6');
        item1.setIcon(R.drawable.ic_launcher_foreground);
    }

    private boolean menuChoice (MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(getBaseContext(), "Clicked Item 1", Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                Toast.makeText(getBaseContext(), "Clicked Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(getBaseContext(), "Clicked Item 3", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(getBaseContext(), "Clicked Item 4", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(getBaseContext(), "Clicked Item 5", Toast.LENGTH_SHORT).show();
                return true;
            case 5:
                Toast.makeText(getBaseContext(), "Clicked Item 6", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return menuChoice(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        createMenu(menu);
    }

}