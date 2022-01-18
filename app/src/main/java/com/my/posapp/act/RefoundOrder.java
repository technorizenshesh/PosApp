package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.my.posapp.R;
import com.my.posapp.adapter.RefoundOrderAdapter;
import com.my.posapp.adapter.WaitingForPaymentAdapter;
import com.my.posapp.databinding.ActivityRefoundOrderBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class RefoundOrder extends AppCompatActivity {

    ActivityRefoundOrderBinding binding;
    private ArrayList<PaymentModel> modelList = new ArrayList<>();
    RefoundOrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_refound_order);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });
        
        setAdapter();

    }


    private void setAdapter() {

        this.modelList.add(new PaymentModel("Corn"));
        this.modelList.add(new PaymentModel("Tomotoes"));

        mAdapter = new RefoundOrderAdapter(RefoundOrder.this,modelList);
        binding.recyclerRefound.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RefoundOrder.this);
        binding.recyclerRefound.setLayoutManager(linearLayoutManager);
        binding.recyclerRefound.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new RefoundOrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

                startActivity(new Intent(RefoundOrder.this,RefoundDetails.class));
            }
        });
    }
}