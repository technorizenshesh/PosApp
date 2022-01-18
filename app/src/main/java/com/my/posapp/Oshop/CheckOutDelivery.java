package com.my.posapp.Oshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCheckOutDeliveryBinding;

public class CheckOutDelivery extends AppCompatActivity {

    ActivityCheckOutDeliveryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_check_out_delivery);

        binding.txtNext.setOnClickListener(v -> {

            startActivity(new Intent(CheckOutDelivery.this, CheckOutAddress.class));

        });

    }
}