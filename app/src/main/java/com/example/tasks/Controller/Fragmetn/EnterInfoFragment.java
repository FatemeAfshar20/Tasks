package com.example.tasks.Controller.Fragmetn;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tasks.Controller.Activity.TasksActivity;
import com.example.tasks.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class EnterInfoFragment extends Fragment {
    public static final String BUNDLE_NAME = "Name";
    public static final String BUNDLE_NUMBER_TASKS = "Number Of Tasks";
    public static final String EXTRA_NAME = "om.example.tasks..Name";
    public static final String EXTRA_NUMBER_TASKS = "com.example.tasks.Number Of  Tasks";
    private TextInputEditText mInputName,mInputNumOfTask;
    private MaterialButton mBtnStart;
    public EnterInfoFragment() {
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
        View view= inflater.inflate(R.layout.fragment_enter_info, container, false);
        findElem(view);
        setListener();
        saveInstance(savedInstanceState);
        return view;
    }

    private void findElem(View view){
    mInputName=view.findViewById(R.id.input_username);
    mInputNumOfTask=view.findViewById(R.id.input_num_of_task);
    mBtnStart=view.findViewById(R.id.btn_start);
    }

    private void setListener(){
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInputName.getText().toString().equals("")  && mInputNumOfTask.getText().toString().equals(""))
                    Toast.makeText(getActivity(),
                            "Name and Num of task cant be empty",
                            Toast.LENGTH_LONG)
                            .show();
                else {
                    Intent intent = new Intent(getActivity(), TasksActivity.class);
                    intent.putExtra(BUNDLE_NAME, mInputName.getText().toString());
                    intent.putExtra(BUNDLE_NUMBER_TASKS,Integer.parseInt(mInputNumOfTask.getText().toString()) );
                    startActivity(intent);
                }
            }
        });

        mInputNumOfTask.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(getContext(),
                        "Please Enter Number for Num Of Tasks ",
                        Toast.LENGTH_LONG).
                        show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getActivity();
        outState.putString(BUNDLE_NAME,mInputName.getText().toString());
        outState.putString(BUNDLE_NUMBER_TASKS,mInputNumOfTask.getText().toString());
    }

    public void saveInstance(Bundle bundle){
            if(bundle!=null){
                mInputName.setText(bundle.getString(BUNDLE_NAME));
                mInputNumOfTask.setText(bundle.getString(BUNDLE_NUMBER_TASKS));
            }
    }
}