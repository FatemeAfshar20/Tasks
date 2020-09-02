package com.example.tasks.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasks.Model.Tasks;
import com.example.tasks.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.Holder>{
   private List<Tasks> mTasks;
   private Context mContext;
   private String mName;

    public TasksAdapter(List<Tasks> tasks, Context context, String name) {
        mTasks = tasks;
        mContext = context;
        mName = name;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.tasks_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        if(position%2==0)
            holder.setBackgroundContent(R.color.yellow_green);
        else
            holder.setBackgroundContent(R.color.beauty_yellow);
        holder.bind(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    protected class Holder extends RecyclerView.ViewHolder {
        private AppCompatImageView mImgTask;
        private MaterialTextView mTaskTitle,mTaskContent,mTaskState;

        public Holder(@NonNull View itemView) {
            super(itemView);
            findElem(itemView);
        }

        public void setBackgroundContent(int resIdColor) {
            mTaskContent.setBackgroundColor(resIdColor);
        }

        private void findElem(View view){
            mImgTask=view.findViewById(R.id.img_content);
            mTaskTitle=view.findViewById(R.id.title);
            mTaskContent=view.findViewById(R.id.content);
            mTaskState=view.findViewById(R.id.task_state);
        }

        public void bind(Tasks tasks){
            mTaskTitle.setText(tasks.getName());
            mTaskState.setText(tasks.getTaskState()+"");
            mImgTask.setBackgroundResource(R.drawable.jeep);
            mTaskContent.setText("This is a work and you should do  "+tasks.getTaskDate());
        }
    }
}
