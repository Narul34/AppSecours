package com.example.a34011_73_08.appsecours;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;


/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class Formulaire extends AppCompatActivity {

    private final String[] arrayBloodType = new String[]{"Bloodtype", "A-", "A+", "B-", "B+", "AB-", "AB+", "O-", "O+"};

    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private RadioButton male;
    private RadioButton female;
    private String sexe;
    private Spinner spBlood;
    private int index;
    private EditText phone;
    private EditText adress;
    private EditText infosComp;

    private Patient patient;
    private Doctor doctor;
    private String drTel;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        age = (EditText) findViewById(R.id.age);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        adress = (EditText) findViewById(R.id.adress);
        phone = (EditText) findViewById(R.id.phone);
        infosComp = (EditText) findViewById(R.id.infoscomp);

        initSpinner();


        Button submit = (Button) findViewById(R.id.submit);

        spBlood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> a,
                                       View v, int position, long id) {

                index = spBlood.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stockData();
            }
        });

        recupData();
    }

    public void initSpinner() {
        spBlood = (Spinner) findViewById(R.id.blood);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Formulaire.this, android.R.layout.simple_spinner_item, arrayBloodType);
        spBlood.setAdapter(adapter);
        spBlood.setSelection(0);
    }

    public void checkRadioButtonState() {
        if (male.isChecked()) {
            sexe = (String) male.getText();
            female.setChecked(false);
        } else if (female.isChecked()) {
            sexe = (String) female.getText();
            male.setChecked(false);
        }

    }

    public void stockData() {
        checkRadioButtonState();

        editor.putString("firstName", firstName.getText().toString());
        editor.putString("lastName", lastName.getText().toString());
        editor.putString("age", age.getText().toString());
        editor.putString("sexe", sexe);
        editor.putString("adress", adress.getText().toString());
        editor.putString("phone", phone.getText().toString());
        editor.putString("index", Integer.toString(index));
        editor.putString("infosComp", infosComp.getText().toString());
        editor.commit();

    }

    public void recupData() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String firstName = sharedPreferences.getString("firstName", "First name?");
        String lastName = sharedPreferences.getString("lastName", "Last name?");
        String age = sharedPreferences.getString("age", "age?");
        String sexe = sharedPreferences.getString("sexe", "gender?");
        String adress = sharedPreferences.getString("adress", "adress?");
        String phone = sharedPreferences.getString("phone", "phone?");
        String index = sharedPreferences.getString("index", "0");
        String infosComp = sharedPreferences.getString("infosComp", "-");

        this.firstName.setText(firstName);
        this.lastName.setText(lastName);
        this.age.setText(age);

        if (sexe.equals("Male"))
        {
            this.male.setChecked(true);
            this.female.setChecked(false);
        }else if (sexe.equals("Female")){
            this.male.setChecked(false);
            this.female.setChecked(true);
        } else{
            this.male.setChecked(false);
            this.female.setChecked(false);
        }

        this.spBlood.setSelection(Integer.parseInt(index));
        this.phone.setText(phone);
        this.adress.setText(adress);
        this.infosComp.setText(infosComp);

    }

    public void showNotif(Context context, String string) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, string, duration);

        toast.show();

    }

}
