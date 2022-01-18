package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityEstimatedFeeBinding;

public class EstimatedFeeActivity extends AppCompatActivity {

    ActivityEstimatedFeeBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_estimated_fee);


        binding.RRback.setOnClickListener(v -> {

            onBackPressed();
        });


        binding.RRAddressAre.setOnClickListener(v -> {

            AlertDaliogArea();

        });

        binding.RRCod.setOnClickListener(v -> {

            AlertDaliogCod();

        });

        binding.RRWeight.setOnClickListener(v -> {

            AlertDaliogWeight();

        });

        binding.RRSize.setOnClickListener(v -> {

            AlertDaliogSize();

        });
    }

    private void AlertDaliogArea() {

        LayoutInflater li;
        RelativeLayout RRArea;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(EstimatedFeeActivity.this);
        promptsView = li.inflate(R.layout.alert_choosearea, null);
        RRArea = (RelativeLayout) promptsView.findViewById(R.id.RRArea);
        alertDialogBuilder = new AlertDialog.Builder(EstimatedFeeActivity.this);
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

    private void AlertDaliogCod() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(EstimatedFeeActivity.this);
        promptsView = li.inflate(R.layout.alert_cod, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(EstimatedFeeActivity.this);
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

    private void AlertDaliogWeight() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(EstimatedFeeActivity.this);
        promptsView = li.inflate(R.layout.alert_weight, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(EstimatedFeeActivity.this);
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

    private void AlertDaliogSize() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(EstimatedFeeActivity.this);
        promptsView = li.inflate(R.layout.alert_size, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(EstimatedFeeActivity.this);
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