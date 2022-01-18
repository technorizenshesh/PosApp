package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityFilterrBinding;

public class FilterrActivity extends AppCompatActivity {

    ActivityFilterrBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_filterr);

       binding.RRback.setOnClickListener(v -> {
           onBackPressed();
       });
    }
}