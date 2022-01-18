package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityDeliveryManageMentBinding;

public class DeliveryManageMent extends AppCompatActivity {

    ActivityDeliveryManageMentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_delivery_manage_ment);

       binding.RRback.setOnClickListener(v -> {

           onBackPressed();
       });
       binding.CreateOrder.setOnClickListener(v -> {

           startActivity(new Intent(DeliveryManageMent.this, CreateOrder.class));
       });
    }
}