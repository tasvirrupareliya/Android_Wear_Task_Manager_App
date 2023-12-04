package com.app.androidweartaskmanagerapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.app.androidweartaskmanagerapp.R;
import com.app.androidweartaskmanagerapp.databinding.ActivityAddTaskBinding;
import com.app.androidweartaskmanagerapp.databinding.ActivityNotificationdetailsBinding;

public class NotificationdetailsActivity extends AppCompatActivity {

    // View binding
    ActivityNotificationdetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using view binding
        binding = ActivityNotificationdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the activity
        init();
    }

    // Initialize activity components
    @SuppressLint("SetTextI18n")
    private void init() {
        // Get intent from the notification
        Intent notificationIntent = getIntent();
        String taskID = notificationIntent.getStringExtra(getString(R.string.i_taskid));
        String taskName = notificationIntent.getStringExtra(getString(R.string.taskname));

        // Set task details in TextViews
        binding.txttaskid.setText("Task ID: " + taskID);
        binding.txttaskname.setText("Task Name: " + taskName);
    }
}