package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        binding.llSingUp.setOnClickListener(v -> {

            startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
        });

        binding.TxtSingUp.setOnClickListener(v -> {

            startActivity(new Intent(SignUpActivity.this,VerificationActivity.class));
        });
    }
}