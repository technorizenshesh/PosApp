package com.my.posapp.act;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityApplyCouapnBinding;

public class ApplyCouapnActivity extends AppCompatActivity {

    ActivityApplyCouapnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_apply_couapn);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}