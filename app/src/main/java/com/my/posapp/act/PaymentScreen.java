package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityPaymentScreenBinding;

public class PaymentScreen extends AppCompatActivity {

    ActivityPaymentScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_payment_screen);

        binding.txtPlaceOrder.setOnClickListener(v -> {
            Toast.makeText(this, "SuccessFully Place", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PaymentScreen.this,HomeActivity.class));
        });

    }
}