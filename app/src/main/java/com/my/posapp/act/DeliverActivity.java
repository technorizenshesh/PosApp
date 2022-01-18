package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityDeliverBinding;

public class DeliverActivity extends AppCompatActivity {

    ActivityDeliverBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_deliver);

       binding.RRback.setOnClickListener(v -> {

           onBackPressed();
       });

       binding.llAddressOne.setOnClickListener(v -> {

           startActivity(new Intent(DeliverActivity.this,ContactWithCompany.class));
       });
    }
}