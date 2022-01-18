package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityAddStockTakingBinding;

public class AddStockTakingActivity extends AppCompatActivity {

    ActivityAddStockTakingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_stock_taking);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });
    }
}