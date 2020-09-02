package com.example.tasks.Repository;

import com.example.tasks.Model.TaskState;
import com.example.tasks.Model.Tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksRepository{
    private static TasksRepository sInstance;
    private List<Tasks> mTasksList=new ArrayList<>();
    private Tasks mTasks;
    private TasksRepository() {
        initTask();
    }

    public List<Tasks> getTasks() {
        return  mTasksList;
    }

    public void addTask(int numOfTask, String name,Date date){
        for (int i = 0; i <numOfTask ; i++) {
            mTasksList.add(new Tasks(date,name));
        }
    }

    public void removeTask(int indexTask){
        mTasksList.remove(indexTask);
    }

    private void initTask(){
        addTask(0,"",new Date());
    }

    public static TasksRepository getInstance() {
        if(sInstance==null)
            sInstance=new TasksRepository();
        return sInstance;
    }
}
