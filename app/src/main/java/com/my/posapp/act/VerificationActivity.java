package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityVerificationBinding;

public class VerificationActivity extends AppCompatActivity {

    ActivityVerificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_verification);

        binding.VerifyBtn.setOnClickListener(v -> {

            startActivity(new Intent(VerificationActivity.this,HomeActivity.class));
            finish();

        });
    }
}