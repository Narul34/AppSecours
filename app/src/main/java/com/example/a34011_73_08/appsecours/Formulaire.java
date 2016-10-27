package com.example.a34011_73_08.appsecours;

import android.content.Context;
import android.os.Bundle;
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
    private String blood;
    private EditText phone;
    private EditText adress;
    private EditText infosComp;

    private Patient patient;
    private Doctor doctor;
    private String drTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


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

                int index = spBlood.getSelectedItemPosition();
                blood = (String)spBlood.getAdapter().getItem(index);
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

        Log.d("DEBUT CLICK", "debut");
        PersFile pf = new PersFile(Formulaire.this);

        checkRadioButtonState();

        String firstName = this.firstName.getText().toString();
        String lastName = this.lastName.getText().toString();
        String age = this.age.getText().toString();
        String sexe = this.sexe;
        String adress = this.adress.getText().toString();
        String phone = this.phone.getText().toString();
        String blood = this.blood;
        String infosComp = this.infosComp.getText().toString();

        patient = new Patient(firstName, lastName, age, sexe, adress, phone, blood, infosComp, null);

        Log.d("AVANT WRITE", "AVANT WRITE");
        pf.write(patient.getAll());

        Log.d("APRES WRITE", "APRES WRITE");

        showNotif(Formulaire.this, "Ecriture reussi");

    }

    public void showNotif(Context context, String string){
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, string, duration);

        toast.show();

    }

}
