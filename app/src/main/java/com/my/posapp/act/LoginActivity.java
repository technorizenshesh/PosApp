package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);

       binding.llSingUp.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
       });

       binding.loginID.setOnClickListener(v ->{

            startActivity(new Intent(LoginActivity.this,HomeActivity.class));

       });

    }

}