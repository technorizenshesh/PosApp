package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.my.posapp.Fragment.BottomFragment;
import com.my.posapp.Fragment.BottomMoreOptionFragment;
import com.my.posapp.Fragment.BottomPaymentOptionFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityWaitingPaymentDetailsBinding;

public class WaitingPaymentDetails extends AppCompatActivity {

    ActivityWaitingPaymentDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_waiting_payment_details);


        binding.imgPayment.setOnClickListener(v -> {
            BottomPaymentOptionFragment bottomSheetFragment= new BottomPaymentOptionFragment(WaitingPaymentDetails.this);
            bottomSheetFragment.show(getSupportFragmentManager(),"ModalBottomSheet");


        });

        binding.imgMore.setOnClickListener(v -> {

            BottomMoreOptionFragment bottomSheetFragment= new BottomMoreOptionFragment(WaitingPaymentDetails.this);
            bottomSheetFragment.show(getSupportFragmentManager(),"ModalBottomSheet");

        });

    }
}