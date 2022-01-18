package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityApprovedOrderBinding;

public class ApprovedOrder extends AppCompatActivity {

    ActivityApprovedOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_approved_order);


    }



}