package com.app.androidweartaskmanagerapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.androidweartaskmanagerapp.adapter.TaskAdapter;
import com.app.androidweartaskmanagerapp.databinding.ActivityListTaskBinding;
import com.app.androidweartaskmanagerapp.model.Task;
import com.app.androidweartaskmanagerapp.utils.Constant;

import java.util.List;

public class ListTaskActivity extends AppCompatActivity {

    ActivityListTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.wrcTaskList.setLayoutManager(layoutManager);

        // Retrieve workoutSession data using SharedPreferencesManager
        List<Task> workoutList = Constant.getAllTasks(this);

        // Create and set adapter with retrieved workout session data
        TaskAdapter adapter = new TaskAdapter(this, workoutList);
        binding.wrcTaskList.setAdapter(adapter);
    }
}