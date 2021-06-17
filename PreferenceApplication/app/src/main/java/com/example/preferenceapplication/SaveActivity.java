package com.example.preferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }

    private void copyFile (String srcPath, String desPath) {
        File src = new File(srcPath);
        File des = new File(desPath);
        try {
            FileChannel srcChannel = new FileInputStream(src).getChannel();
            FileChannel desChannel = new FileInputStream(des).getChannel();
            try {
                desChannel.transferFrom(srcChannel, 0, srcChannel.size());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (srcChannel != null) {
                        srcChannel.close();
                    }
                    if (desChannel != null) {
                        desChannel.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnSaveInternal(View view) {
    }

    public void btnLoadInternal(View view) {
    }

    public void btnSaveExternal(View view) {
    }

    public void btnLoadExternal(View view) {
    }

    public void btnCopy(View view) {
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File data = Environment.getDataDirectory();
        String desDir = realPath + "/MyFiles";
        File directory = new File(desDir);
        directory.mkdir();
        System.out.println(desDir);

        String dataPath = "/data/" + this.getPackageName() + "/shared_prefs";
        System.out.println(dataPath);
        File dataDir = new File(data, dataPath);
        File[] files = dataDir.listFiles();

        String result = "Copied Files: \n";
        if (files != null) {
            result += "-shared_prefs directory: \n";
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                result += f.getName() + "\n";
                copyFile(f.getAbsolutePath(), desDir + "/" + f.getName());
            }
        } else {
            result += "-shared_prefs directory: No File\n";
        }
        dataPath = "/data/" + this.getPackageName() + "/files";

        dataDir = new File(data, dataPath);
        files = dataDir.listFiles();

        if (files != null) {
            result += "-shared_prefs directory: \n";
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                result += f.getName() + "\n";
                copyFile(f.getAbsolutePath(), desDir + "/" + f.getName());
            }
        } else {
            result += "-shared_prefs directory: No File\n";
        }



    }
}