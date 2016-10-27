package com.example.a34011_73_08.appsecours;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by 34011-73-05 on 27/10/2016.
 */


public class CustomIntent {
    Context context;
    String action;
    RemoteViews views;
    int resID;

    public CustomIntent(Context context, String action, RemoteViews views, int resID){
        this.context = context;
        this.action = action;
        this.views = views;
        this.resID = resID;
        createIntent();
    }

    public void createIntent(){
        Intent intent = new Intent(context, ChooseActivity.class);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(resID, pendingIntent);
    }
}
