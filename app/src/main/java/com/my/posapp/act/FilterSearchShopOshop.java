package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityFilterSearchShopOshopBinding;

public class FilterSearchShopOshop extends AppCompatActivity {

    ActivityFilterSearchShopOshopBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_filter_search_shop_oshop);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });
    }
}