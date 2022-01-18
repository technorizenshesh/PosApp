package com.my.posapp.Oshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCheckOutAddressBinding;

public class CheckOutAddress extends AppCompatActivity {

    ActivityCheckOutAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_check_out_address);

       binding.txtNext.setOnClickListener(v -> {

           startActivity(new Intent(CheckOutAddress.this, CheckOutPaymentActivity.class));

       });
    }
}