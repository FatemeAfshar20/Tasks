package com.example.tasks.Controller.Activity;

import androidx.fragment.app.Fragment;

import com.example.tasks.SingleFragment;
import com.example.tasks.Controller.Fragmetn.TasksFragment;

public class TasksActivity extends SingleFragment {

    @Override
    public Fragment getFragment() {
        return new TasksFragment();
    }
}