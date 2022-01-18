package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityAddSupplyBinding;

public class AddSupplyActivity extends AppCompatActivity {

    private View promptsView;
    private AlertDialog alertDialog;
    ActivityAddSupplyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_supply);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRArea.setOnClickListener(v -> {

            AlertDaliogArea();

        });

        binding.RRsubdistrict.setOnClickListener(v -> {

            AlertDaliogsubdistrict();

        });
    }

    private void AlertDaliogArea() {

        LayoutInflater li;
        RelativeLayout RRArea;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(AddSupplyActivity.this);
        promptsView = li.inflate(R.layout.alert_choosearea, null);
        RRArea = (RelativeLayout) promptsView.findViewById(R.id.RRArea);
        alertDialogBuilder = new AlertDialog.Builder(AddSupplyActivity.this);
        alertDialogBuilder.setView(promptsView);

        RRArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    private void AlertDaliogsubdistrict() {

        LayoutInflater li;
        RelativeLayout RRArea;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(AddSupplyActivity.this);
        promptsView = li.inflate(R.layout.alert_subtracts, null);
        RRArea = (RelativeLayout) promptsView.findViewById(R.id.RRArea);
        alertDialogBuilder = new AlertDialog.Builder(AddSupplyActivity.this);
        alertDialogBuilder.setView(promptsView);

        RRArea.setOnClickListener(new View.OnClickListener() {
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