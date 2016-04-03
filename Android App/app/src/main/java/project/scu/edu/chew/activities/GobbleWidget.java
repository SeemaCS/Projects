package project.scu.edu.chew.activities;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import project.scu.edu.chew.R;

/**
 * Implementation of App Widget functionality.
 */
public class GobbleWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);

        Intent intent = new Intent(context, SearchActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.gobble_widget);
        views.setOnClickPendingIntent(R.id.wsearchButton, pendingIntent);

        Intent intent2 = new Intent(context, CartActivity10.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 0,	intent2, 0);
        views.setOnClickPendingIntent(R.id.wcartButton, pendingIntent2);

        Intent intent3 = new Intent(context, NearestKitchenActivity.class);
        PendingIntent pendingIntent3 = PendingIntent.getActivity(context, 0,	intent3, 0);
        views.setOnClickPendingIntent(R.id.wmapButton, pendingIntent3);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
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

