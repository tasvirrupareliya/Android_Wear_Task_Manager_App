package com.app.androidweartaskmanagerapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;

import com.app.androidweartaskmanagerapp.adapter.TaskAdapter;
import com.app.androidweartaskmanagerapp.databinding.ActivityUpcomingTasksBinding;
import com.app.androidweartaskmanagerapp.model.Task;
import com.app.androidweartaskmanagerapp.utils.Constant;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class UpcomingTasksActivity extends AppCompatActivity {

    // View binding
    ActivityUpcomingTasksBinding binding;

    // Date format for task timestamps
    public static final SimpleDateFormat customDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using view binding
        binding = ActivityUpcomingTasksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve upcoming tasks within one hour
        List<Task> upcomingTasks = getUpcomingTasksWithinOneHour();

        // Set up RecyclerView with the adapter
        binding.wrcUpTaskList.setLayoutManager(new LinearLayoutManager(UpcomingTasksActivity.this));
        TaskAdapter adapter = new TaskAdapter(UpcomingTasksActivity.this, upcomingTasks);
        binding.wrcUpTaskList.setAdapter(adapter);
    }

    // Retrieve upcoming tasks within one hour
    private List<Task> getUpcomingTasksWithinOneHour() {
        // Get all tasks from storage
        List<Task> allTasks = Constant.getAllTasks(this);

        // Filter tasks to get those upcoming within one hour
        return Constant.getUpcomingTasksWithinOneHour(allTasks);
    }
}