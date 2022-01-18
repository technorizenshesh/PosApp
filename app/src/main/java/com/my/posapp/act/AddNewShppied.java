package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.my.posapp.Fragment.IntegratedFragment;
import com.my.posapp.Fragment.addinvisualFragment;
import com.my.posapp.Fragment.storeShipperFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityAddNewShppiedBinding;

public class AddNewShppied extends AppCompatActivity {

    ActivityAddNewShppiedBinding binding;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_shppied);

        binding.txtAddINDIVIDUAL.setOnClickListener(v -> {

            binding.txtAddINDIVIDUAL.setTextColor(getResources().getColor(R.color.blue));
            binding.txtAddSTORE.setTextColor(getResources().getColor(R.color.gray_new));

            binding.viewintregrated.setBackgroundResource(R.color.blue);
            binding.viewCon.setBackgroundResource(R.color.natural_gray);

            fragment = new addinvisualFragment();
            loadFragment(fragment);
        });

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.txtAddSTORE.setOnClickListener(v -> {

            binding.txtAddINDIVIDUAL.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtAddSTORE.setTextColor(getResources().getColor(R.color.blue));


            binding.viewintregrated.setBackgroundResource(R.color.natural_gray);
            binding.viewCon.setBackgroundResource(R.color.blue);

            fragment = new storeShipperFragment();
            loadFragment(fragment);
        });

        fragment = new addinvisualFragment();
        loadFragment(fragment);
        
    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentAddshppied, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}