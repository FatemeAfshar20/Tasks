package com.example.tasks.Controller.Fragmetn;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tasks.Adapter.TasksAdapter;
import com.example.tasks.Model.Tasks;
import com.example.tasks.R;
import com.example.tasks.Repository.TasksRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksFragment extends Fragment {
    public static final String ARG_NAME = "Name";
    public static final String ARG_NUM_OF_TASK = "Num Of Task";
    public static final String BUNDLE_NAME = "Name";
    public static final String BUNDLE_NUM_OF_TASK = "Num Of Task";
    public static final String BUNDLE_TASK_SIZE = "Task Size";
    public static final String BUNDLE_TASK_LIST = "Task List";
    public TasksRepository mRepository = TasksRepository.getInstance();
    private AppCompatImageView mBtnAdd;
    private RecyclerView mRecyclerView;
    private ArrayList<Tasks> tasks = TasksRepository.getInstance().getTasks();
    private String mName = "";
    private int mNumOfTasks = 0;

    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance(String name, int numOfTask) {

        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_NUM_OF_TASK, numOfTask);
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null; //---- what is it?-----
        mName = getArguments().getString(ARG_NAME);
        mNumOfTasks = getArguments().getInt(ARG_NUM_OF_TASK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
            // set diff view for land and port
            if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            else
                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mRecyclerView.setAdapter(new TasksAdapter(tasks, getContext(), mName));

        findElem(view);
        setListener();
        saveInstance(savedInstanceState);
        //saveInstance(savedInstanceState);
        return view;
    }

    private void findElem(View view) {
        mBtnAdd = view.findViewById(R.id.btn_add);
    }

    private void setListener() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasksRepository.getInstance().addTask(1, mName, new Date());
                mRecyclerView.setAdapter(new TasksAdapter(tasks, getContext(), mName));
            }
        });
    }

    private void saveInstance(Bundle bundle) {
        if (bundle != null) {
            mName = bundle.getString(BUNDLE_NAME);
            mNumOfTasks =
                    bundle.getInt(BUNDLE_NUM_OF_TASK);
        }else
            mRepository.addTask(mNumOfTasks,
                    mName, new Date());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int taskListSize = tasks.size();
        outState.putString(BUNDLE_NAME, mName);
        outState.putInt(BUNDLE_NUM_OF_TASK, mNumOfTasks);
        outState.putInt(BUNDLE_TASK_SIZE, taskListSize);
        outState.putParcelableArrayList(BUNDLE_TASK_LIST, tasks);
    }
}