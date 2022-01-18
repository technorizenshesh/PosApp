package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCreatePaymentOrderBinding;

public class CreatePaymentOrder extends AppCompatActivity {

    ActivityCreatePaymentOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_create_payment_order);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });
    }
}