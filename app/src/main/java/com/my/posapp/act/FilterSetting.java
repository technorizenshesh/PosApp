package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityFilterSettingBinding;

public class FilterSetting extends AppCompatActivity {

    ActivityFilterSettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_filter_setting);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

    }
}