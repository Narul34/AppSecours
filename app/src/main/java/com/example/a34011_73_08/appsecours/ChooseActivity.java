package com.example.a34011_73_08.appsecours;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        Button police = (Button) findViewById(R.id.buttonPolice);
        Button pompier = (Button) findViewById(R.id.buttonPompier);
        Button samu = (Button) findViewById(R.id.buttonSamu);


        setListener(police, "0634239221");
        setListener(pompier, "0660506838");
        setListener(samu, "2");


    }

//@TODO résoudre appel direct
    public void setListener(Button button, final String tel) {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + tel));
                    startActivity(intent);
                } catch (ActivityNotFoundException | SecurityException e) {
                    Log.e("Ceci est l'erreur", "appel a echoué", e);
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch(requestCode){
            case 123:
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                onCall();
            } else {
                Log.d("TAG", "Call Permission Not Granted");
            }
            break;

            default:
                break;
        }

    }

    public void onCall(final String tel){

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tel)));
        }

    }

}
