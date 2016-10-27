package com.example.a34011_73_08.appsecours;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class SecoursWidget extends AppWidgetProvider {
    public static final String OUVERTURE = "ouvrir";


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        final int count = appWidgetIds.length;

        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.secours_widget);


            CustomIntent police = new CustomIntent(context, "police", views, R.id.buttonWpolice);
            CustomIntent samu = new CustomIntent(context, "samu", views, R.id.buttonWsamu);
            CustomIntent le112 = new CustomIntent(context, "le112", views, R.id.buttonW112);
            CustomIntent pompier = new CustomIntent(context, "pompier", views, R.id.buttonWpompier);


            // Prepare intent to launch on widget click




            // Launch intent on widget click




            appWidgetManager.updateAppWidget(appWidgetIds, views);

        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}

