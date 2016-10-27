package com.example.a34011_73_08.appsecours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button formulaire = (Button) findViewById(R.id.buttonForm);

        setListener(formulaire, Formulaire.class);
    }


    public void setListener(Button button, final Class classe) {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, classe);
                startActivity(intent);
            }
        });

    }
}
