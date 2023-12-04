package com.app.androidweartaskmanagerapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.app.androidweartaskmanagerapp.R;

public class WearActionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null && intent.getAction().equals(context.getString(R.string.wear_action))) {
            // Handle the action on the wearable
            Intent updateIntent = new Intent(context, UpcomingTasksActivity.class);
            updateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Add a flag to indicate that it should display upcoming tasks within one hour
            updateIntent.putExtra(context.getString(R.string.show_upcoming_within_one_hour), true);
            context.startActivity(updateIntent);
        }

        if (intent.getAction() != null && intent.getAction().equals(context.getString(R.string.check_notifications))) {
            AddTaskActivity.checkTriggerApproachingTaskNotifications(context);
        }
    }
}
