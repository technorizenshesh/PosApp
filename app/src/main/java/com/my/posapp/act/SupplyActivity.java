package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivitySupplyBinding;

public class SupplyActivity extends AppCompatActivity {

    ActivitySupplyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_supply);

       binding.RRBack.setOnClickListener(v -> {
           onBackPressed();
       });

       binding.RRAddsupply.setOnClickListener(v -> {

           startActivity(new Intent(SupplyActivity.this,AddSupplyActivity.class));

       });
    }
}