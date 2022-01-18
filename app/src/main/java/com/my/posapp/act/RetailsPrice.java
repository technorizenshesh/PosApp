package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityRetailsPriceBinding;

public class RetailsPrice extends AppCompatActivity {

    ActivityRetailsPriceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_retails_price);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRRetailsPrice.setOnClickListener(v -> {

            binding.imgRetailsPrice.setImageResource(R.drawable.blue_circle);
            binding.imgWholePrice.setImageResource(R.drawable.blue_circle_new);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent=new Intent();
                    intent.putExtra("Type","Retails");
                    setResult(104,intent);
                    finish();
                }
            }, 1000);


        });

        binding.RRwholePrice.setOnClickListener(v -> {

            binding.imgRetailsPrice.setImageResource(R.drawable.blue_circle_new);
            binding.imgWholePrice.setImageResource(R.drawable.blue_circle);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent=new Intent();
                    intent.putExtra("Type","WholeShale");
                    setResult(104,intent);
                    finish();

                }
            }, 1000);
        });
    }
}