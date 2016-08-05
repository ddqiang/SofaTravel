package com.example.dllo.sofatravel.main.main.tools.imagecache;

import com.example.dllo.sofatravel.main.main.base.MyApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * Created by dllo on 16/7/30.
 */
public class CacheFile {

    //取流
    public static String loading() {
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            inputStream = MyApplication.context.openFileInput("dataCache");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }

    //存流
    public static void Save(String s) {

        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try {
            outputStream = MyApplication.context.openFileOutput("dataCache", MyApplication.context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
