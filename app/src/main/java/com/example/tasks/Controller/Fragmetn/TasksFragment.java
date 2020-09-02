package com.example.tasks.Controller.Fragmetn;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tasks.Adapter.TasksAdapter;
import com.example.tasks.Model.Tasks;
import com.example.tasks.R;
import com.example.tasks.Repository.TasksRepository;

import java.util.Date;
import java.util.List;

public class TasksFragment extends Fragment {
    private AppCompatImageView mBtnAdd;
    private RecyclerView mRecyclerView;
    private List<Tasks> tasks=TasksRepository.getInstance().getTasks();
    private String name="";

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tasks, container, false);
        mRecyclerView=view.findViewById(R.id.recycler_view);
        if(savedInstanceState==null)
              setIntent();
        // set diff view for land and port
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        else
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        mRecyclerView.setAdapter(new TasksAdapter(tasks, getContext(),name));

        findElem(view);
        setListener();
        //saveInstance(savedInstanceState);
        return view;
    }

    private void setIntent() {
        int numOfTasks = getActivity().getIntent().getIntExtra(EnterInfoFragment.BUNDLE_NUMBER_TASKS, 1);
        name=getActivity().getIntent().getStringExtra(EnterInfoFragment.BUNDLE_NAME);
        TasksRepository.getInstance().addTask(numOfTasks,name,new Date());
    }

    private  void findElem(View view){
        mBtnAdd=view.findViewById(R.id.btn_add);
    }

    private void setListener(){
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasksRepository.getInstance().addTask(1,name,new Date());
                mRecyclerView.setAdapter(new TasksAdapter(tasks, getContext(),name));
            }
        });
    }

}