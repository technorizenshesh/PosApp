package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.my.posapp.MainActivity;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityChooseLoginBinding;

public class ChooseLoginActivity extends AppCompatActivity {

    ActivityChooseLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_choose_login);

        binding.imgManagger.setOnClickListener(view -> {

            Intent i = new Intent(ChooseLoginActivity.this, LoginActivity.class);
            i.putExtra("Type","OshopManager");
            startActivity(i);

        });

        binding.imgShops.setOnClickListener(view -> {

            Intent i = new Intent(ChooseLoginActivity.this, LoginActivity.class);
            i.putExtra("Type","Oshop");
            startActivity(i);

        });
    }
}