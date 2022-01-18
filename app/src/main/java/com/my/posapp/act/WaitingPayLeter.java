package com.my.posapp.act;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.posapp.Fragment.BottomMoreOptionFragment;
import com.my.posapp.Fragment.BottomPaymentOptionFragment;
import com.my.posapp.Fragment.BottomShippingMethodFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityWaitingPayLeterBinding;
import com.my.posapp.databinding.ActivityWaitingPaymentDetailsBinding;

public class WaitingPayLeter extends AppCompatActivity {

    ActivityWaitingPayLeterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_waiting_pay_leter);


        binding.imgPayDeliver.setOnClickListener(v -> {

            startActivity(new Intent(WaitingPayLeter.this,MoreDetailsSales.class));

        });

        binding.imgMore.setOnClickListener(v -> {

            BottomShippingMethodFragment bottomSheetFragment= new BottomShippingMethodFragment(WaitingPayLeter.this);
            bottomSheetFragment.show(getSupportFragmentManager(),"ModalBottomSheet");

        });

    }
}