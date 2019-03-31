package com.example.fumblevore_gaming.mastercasproject;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.*;
import java.io.*;

public class FileWriting {
    final static String FILENAME = "tasks.txt";


    public static ArrayList<String> ReadFile( Context context){
        final String path = context.getFilesDir().getAbsolutePath();
        File f = new File(path + FILENAME);

        ArrayList<String> tasks = new ArrayList<>();
        String line;

        try {

            FileInputStream fileInputStream = new FileInputStream (f);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ( (line = bufferedReader.readLine()) != null ){
                tasks.add(line);
            }
            fileInputStream.close();
            bufferedReader.close();

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public static boolean saveToFile(Context context, String data){
        final String path = context.getFilesDir().getAbsolutePath();
        try {
            new File(path).mkdir();
            File file = new File(path + FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());

            return true;
        }  catch(FileNotFoundException e) {
            e.printStackTrace();
        }  catch(IOException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public static void clearFile(Context context){
        final String path = context.getFilesDir().getAbsolutePath();

        try{
            FileOutputStream fos = new FileOutputStream(path+FILENAME);
            fos.write(("").getBytes());
            fos.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
