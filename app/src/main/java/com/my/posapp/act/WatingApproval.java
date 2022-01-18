package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityWatingApprovalBinding;

public class WatingApproval extends AppCompatActivity {

    ActivityWatingApprovalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_wating_approval);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRfilter.setOnClickListener(v -> {

            startActivity(new Intent(WatingApproval.this,FilterrActivity.class));

        });

    }
}