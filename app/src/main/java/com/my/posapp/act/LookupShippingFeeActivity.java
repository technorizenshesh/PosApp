package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityLookupShippingFeeBinding;

public class LookupShippingFeeActivity extends AppCompatActivity {

    ActivityLookupShippingFeeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_lookup_shipping_fee);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.txtLookup.setOnClickListener(v -> {


        });
    }
}