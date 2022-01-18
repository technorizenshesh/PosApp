package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityDebtReconciliationActtivityBinding;

public class DebtReconciliationActtivity extends AppCompatActivity {

    ActivityDebtReconciliationActtivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_debt_reconciliation_acttivity);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.txtDebtReconciliation.setOnClickListener(v -> {
            startActivity(new Intent(DebtReconciliationActtivity.this, CreateOrder.class));
        });

    }
}