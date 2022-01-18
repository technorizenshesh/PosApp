package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.my.posapp.Fragment.HomeFragment;
import com.my.posapp.Fragment.IntegratedFragment;
import com.my.posapp.Fragment.InveraryReportFragment;
import com.my.posapp.Fragment.SelfContratedFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityShippedBinding;

public class ShippedActivity extends AppCompatActivity {

    ActivityShippedBinding binding;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_shipped);


        binding.txtINTEGRATED.setOnClickListener(v -> {

            binding.txtINTEGRATED.setTextColor(getResources().getColor(R.color.blue));
            binding.txtCONTRACTED.setTextColor(getResources().getColor(R.color.gray_new));

            binding.viewintregrated.setBackgroundResource(R.color.blue);
            binding.viewCon.setBackgroundResource(R.color.natural_gray);
            fragment = new IntegratedFragment();
            loadFragment(fragment);

        });

        binding.txtCONTRACTED.setOnClickListener(v -> {

            binding.txtINTEGRATED.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtCONTRACTED.setTextColor(getResources().getColor(R.color.blue));


            binding.viewintregrated.setBackgroundResource(R.color.natural_gray);
            binding.viewCon.setBackgroundResource(R.color.blue);
            
            fragment = new SelfContratedFragment();
            loadFragment(fragment);
        });

        fragment = new IntegratedFragment();
        loadFragment(fragment);
    }


    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentshppied, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}