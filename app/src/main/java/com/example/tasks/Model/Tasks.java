package com.example.tasks.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Tasks implements Serializable {
    private UUID mUUID= UUID.randomUUID();
    private String mName;
    private Date mTaskDate;
    private int mImgId;
    private String mTaskContent;

    public Tasks(Date taskDate,String name) {
        mTaskDate = taskDate;
        mName=name;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getTaskContent() {
        return mTaskContent;
    }

    public void setTaskContent(String taskContent) {
        mTaskContent = taskContent;
    }


    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int imgId) {
        mImgId = imgId;
    }

    public Date getTaskDate() {
        mTaskDate=new Date();
        return mTaskDate;
    }

    public void setTaskDate(Date taskDate) {
        mTaskDate = taskDate;
    }

    public TaskState getTaskState() {
        int rand=randomNum(0,2);
        switch (rand){
            case 0:
                return TaskState.TODO;
            case 1:
                return TaskState.DOING;
            case 2:
                return TaskState.DONE;
            default:
                break;
        }
        return null;
    }

    private int randomNum(int min,int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

}
