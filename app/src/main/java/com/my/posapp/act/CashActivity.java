package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCashBinding;

public class CashActivity extends AppCompatActivity {

    ActivityCashBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_cash);

       binding.RRback.setOnClickListener(v -> {
           onBackPressed();
       });

       binding.txtLocation.setOnClickListener(v -> {

           AlertDaliogAre();
       });

       binding.txtFilter.setOnClickListener(v -> {

           startActivity(new Intent(CashActivity.this,FilterSetting.class));

       });

    }


    private void AlertDaliogAre() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CashActivity.this);
        promptsView = li.inflate(R.layout.alert_choose_location, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(CashActivity.this);
        alertDialogBuilder.setView(promptsView);

        RRcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}