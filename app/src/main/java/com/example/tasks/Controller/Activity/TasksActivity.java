package com.example.tasks.Controller.Activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.tasks.SingleFragment;
import com.example.tasks.Controller.Fragmetn.TasksFragment;

public class TasksActivity extends SingleFragment {

    public static final String EXTRA_USER_NAME =
            "com.example.tasks.Controller.User name";
    public static final String EXTRA_NUMBER_OF_TASK =
            "com.example.tasks.Controller.Number of Task";

    public static void start(Context context, String name, int number) {
        Intent starter = new Intent(context, TasksActivity.class);
        starter.putExtra(EXTRA_USER_NAME,name);
        starter.putExtra(EXTRA_NUMBER_OF_TASK,number);
        context.startActivity(starter);
    }

    @Override
    public Fragment getFragment() {
        return TasksFragment.newInstance(
                getIntent().getStringExtra(TasksActivity.EXTRA_USER_NAME),
                getIntent().getIntExtra(TasksActivity.EXTRA_NUMBER_OF_TASK,0)
        );
    }
}