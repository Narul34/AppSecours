package com.example.a34011_73_08.appsecours;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 34011-73-08 on 24/10/2016.
 */

public class ChooseActivity extends AppCompatActivity {

    private String numPolice = "0625895628";
    private String numPompier = "0650302314";
    private String numSamu = "0622063174";
    private String num112 = "0602519589";
    private String selectedTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ImageView img = (ImageView)findViewById(R.id.img);

        Intent intent = getIntent();

            if(intent.getAction().equals("pompier")){
                showNotification(ChooseActivity.this, "Appel vers pompier");
                img.setImageResource(R.drawable.logopompier);
                onCall(numPompier);

            }
            else if(intent.getAction().equals("samu")){
                showNotification(ChooseActivity.this, "Appel vers samu");
                img.setImageResource(R.drawable.samu);
                onCall(numSamu);

            }
            else if(intent.getAction().equals("le112")){
                showNotification(ChooseActivity.this, "Appel vers 112");
                img.setImageResource(R.drawable.num112);
                onCall(num112);

            }
            else if(intent.getAction().equals("police")){
                showNotification(ChooseActivity.this, "Appel vers police");
                img.setImageResource(R.drawable.police);
                onCall(numPolice);

            }



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent form = new Intent(ChooseActivity.this, Formulaire.class);
        startActivity(form);
        finish();
    }

    public void setListener(Button button, final String tel) {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onCall(tel);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall(selectedTel);
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }

    }

    public void onCall(final String tel) {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            this.selectedTel = tel;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tel)));
        }

    }
    protected void showNotification(Context context, String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
