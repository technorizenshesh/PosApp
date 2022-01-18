package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityStockTrakingBinding;

public class StockTrakingActivity extends AppCompatActivity {

    ActivityStockTrakingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_stock_traking);

       binding.RRAddStocktaking.setOnClickListener(v -> {

           startActivity(new Intent(StockTrakingActivity.this,AddStockTakingActivity.class));

       });
    }
}