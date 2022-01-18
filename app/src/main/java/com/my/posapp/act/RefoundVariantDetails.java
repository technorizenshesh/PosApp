package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityRefoundVariantDetailsBinding;

public class RefoundVariantDetails extends AppCompatActivity {

    ActivityRefoundVariantDetailsBinding binding;
    private View promptsView;
    private AlertDialog  alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_refound_variant_details);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRedit.setOnClickListener(v -> {

            startActivity(new Intent(RefoundVariantDetails.this,EditVariantDetails.class));
        });

        binding.RRDelete.setOnClickListener(v -> {

            AlertDaliog();
        });
    }

    private void AlertDaliog() {

        LayoutInflater li;
        TextView txtExit;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(this);
        promptsView = li.inflate(R.layout.alert_dailoge, null);
        txtExit = (TextView) promptsView.findViewById(R.id.txtExit);
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);

        txtExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}