package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityRefoundDetailsBinding;

public class RefoundDetails extends AppCompatActivity {

    ActivityRefoundDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this,R.layout.activity_refound_details);

       binding.RRback.setOnClickListener(v -> {
           onBackPressed();
       });

       binding.RRRefoundDetails.setOnClickListener(v -> {

           startActivity(new Intent(RefoundDetails.this,RefoundVariantDetails.class));

       });

    }

}