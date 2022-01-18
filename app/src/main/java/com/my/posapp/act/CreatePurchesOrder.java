package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCreateOrderBinding;
import com.my.posapp.databinding.ActivityCreatePurchesOrderBinding;

public class CreatePurchesOrder extends AppCompatActivity {

    ActivityCreatePurchesOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_create_purches_order);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}