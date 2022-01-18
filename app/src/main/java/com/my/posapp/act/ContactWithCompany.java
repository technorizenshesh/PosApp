package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityContactWithCompanyBinding;

public class ContactWithCompany extends AppCompatActivity {

    ActivityContactWithCompanyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_contact_with_company);

           binding.RRback.setOnClickListener(v -> {

               onBackPressed();

           });

           binding.RRConfirm.setOnClickListener(v -> {

               startActivity(new Intent(ContactWithCompany.this,FinalOrderDelivery.class));
           });
    }
}