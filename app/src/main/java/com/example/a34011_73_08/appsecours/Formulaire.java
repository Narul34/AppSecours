package com.example.a34011_73_08.appsecours;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class Formulaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        String[] arrayBloodType = new String[] {"Bloodtype", "A-","A+","B-","B+","AB-","AB+","O-","O+"};

        Spinner spBlood = (Spinner) findViewById(R.id.blood);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayBloodType);

        
        spBlood.setAdapter(adapter);
        spBlood.setSelection(0);

    }
}
