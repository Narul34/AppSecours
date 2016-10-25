package com.example.a34011_73_08.appsecours;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 34011-73-08 on 25/10/2016.
 */

public class PersFile {

    FileInputStream in = null;
    FileOutputStream out = null;



    public void write( String infosPatient){
        try {
            File file = new File("fiche_patient.txt");
            out = new FileOutputStream(file);

            for (int i = 0; i < infosPatient.length(); i++){
                int caractere = infosPatient.charAt(i);
                out.write(caractere);
            }


            if (file.exists()){
                read(file);
            }

            if(out != null)
                out.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void read( File file){

        try{
            in = new FileInputStream(file);
            int caractere;

            while (( in.read()) != -1) {
                Log.d("FICHIER", file.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
