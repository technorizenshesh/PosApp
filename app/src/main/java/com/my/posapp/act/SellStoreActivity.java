package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivitySellStoreBinding;

public class SellStoreActivity extends AppCompatActivity {

    ActivitySellStoreBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sell_store);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRDiscount.setOnClickListener(v -> {

            AlertDaliog();

        });

        binding.RRAddCustomer.setOnClickListener(v -> {

            startActivity(new Intent(SellStoreActivity.this,AddNewShppied.class));

        });

        binding.RRRetailsPrice.setOnClickListener(v -> {

            startActivity(new Intent(SellStoreActivity.this,RetailsPrice.class));

        });

        binding.llSelectProduct.setOnClickListener(v -> {

            startActivity(new Intent(SellStoreActivity.this,AllProductListActivity.class));

        });

    }

    private void AlertDaliog() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(SellStoreActivity.this);
        promptsView = li.inflate(R.layout.alert_discount, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(SellStoreActivity.this);
        alertDialogBuilder.setView(promptsView);

        RRcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}