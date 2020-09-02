package com.example.tasks.Controller.Activity;

import androidx.fragment.app.Fragment;

import com.example.tasks.Controller.Fragmetn.EnterInfoFragment;
import com.example.tasks.SingleFragment;

public class EnterInfoActivity extends SingleFragment {

    @Override
    public Fragment getFragment() {
        return new EnterInfoFragment();
    }

}