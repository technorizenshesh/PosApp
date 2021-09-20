package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.my.posapp.R;
import com.my.posapp.adapter.WaitingForPaymentAdapter;
import com.my.posapp.databinding.ActivityWaitingForPaymentBinding;
import com.my.posapp.databinding.ActivityWaitingForPockedBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class WaitingForPocked extends AppCompatActivity {

    private ArrayList<PaymentModel> modelList = new ArrayList<>();
    WaitingForPaymentAdapter mAdapter;
    ActivityWaitingForPockedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_waiting_for_pocked);

    }

    private void setAdapter() {

        this.modelList.add(new PaymentModel("Corn"));
        this.modelList.add(new PaymentModel("Tomotoes"));
        this.modelList.add(new PaymentModel("Tomotoes"));
        this.modelList.add(new PaymentModel("Tomotoes"));


        mAdapter = new WaitingForPaymentAdapter(WaitingForPocked.this,modelList);
        binding.recyclerCustomersall.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WaitingForPocked.this);
        binding.recyclerCustomersall.setLayoutManager(linearLayoutManager);
        binding.recyclerCustomersall.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new WaitingForPaymentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

                startActivity(new Intent(WaitingForPocked.this, WaitingPaymentDetails.class));
            }
        });
    }
}