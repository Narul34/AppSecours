package com.example.a34011_73_08.appsecours;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class SecoursWidget extends AppWidgetProvider {
    public static final String OUVERTURE = "ouvrir";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        CharSequence widgetText = "AppSecours";
        // Prepare widget views
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.secours_widget);
        views.setTextViewText(R.id.button, "Clic");

        int rand = (int) Math.random()*1000;
        views.setTextViewText(R.id.textView, Integer.toString(rand));

        // Prepare intent to launch on widget click
        Intent intent = new Intent(context, SecoursWidget.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setAction(OUVERTURE);

        // Launch intent on widget click
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.button, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.secours_widget);


        for (int appWidgetId : appWidgetIds) {

            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context, intent);

        if(OUVERTURE.equals(intent.getAction())){
            showNotification(context, "J'ai cliqué");
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

    protected void showNotification(Context context, String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}

