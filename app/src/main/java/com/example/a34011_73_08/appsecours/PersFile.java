package com.example.a34011_73_08.appsecours;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 34011-73-08 on 25/10/2016.
 */

public class PersFile {

    private Context context;
    private FileInputStream in = null;
    private FileOutputStream out = null;


    public PersFile(Context context){
        this.context = context;
    }


    public void write( String infosPatient){
        try {
            out = context.openFileOutput("fiche_patient.txt", Context.MODE_PRIVATE);
           // String path = context.getFilesDir().getPath() + "/fiche_patient.txt";
            File file = new File(context.getFilesDir() + "/fiche_patient.txt");


            for (int i = 0; i < infosPatient.length(); i++){
               // int caractere = infosPatient.charAt(i);
                Log.d("Le caractere : ", infosPatient);
                out.write(infosPatient.getBytes());
            }



            if (file.exists()){
                read(file);
                Log.d("tes dans le READ :", "niquel");
            }

            if(out != null)
                out.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void read( File file){

        try{
            in = new FileInputStream(file);
            StringBuffer sb = new StringBuffer();
            sb.append((char)4);
            while (( in.read()) != -1) {
                Log.d("FICHIER", file.toString());
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
