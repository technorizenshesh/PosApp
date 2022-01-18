package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityFinalOrderDeliveryBinding;

public class FinalOrderDelivery extends AppCompatActivity {

    ActivityFinalOrderDeliveryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_final_order_delivery);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();
        });

        binding.RRConfirm.setOnClickListener(v -> {

        });
    }
}