package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.my.posapp.Fragment.DeliveryFragment;
import com.my.posapp.Fragment.HomeFragment;
import com.my.posapp.Fragment.MoreBottomFragment;
import com.my.posapp.Fragment.OrderFragment;
import com.my.posapp.Fragment.ProductFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        binding.RRHome.setOnClickListener(v -> {

            fragment = new HomeFragment();
            loadFragment(fragment);

        });

        binding.RROrder.setOnClickListener(v -> {

            fragment = new OrderFragment();
            loadFragment(fragment);

        });

        binding.RRDelivery.setOnClickListener(v -> {

            fragment = new DeliveryFragment();
            loadFragment(fragment);

        });

        binding.RRProduct.setOnClickListener(v -> {

            fragment = new ProductFragment();
            loadFragment(fragment);

        });

        binding.RRMore.setOnClickListener(v -> {

            fragment = new MoreBottomFragment();
            loadFragment(fragment);

        });

        fragment = new HomeFragment();
        loadFragment(fragment);

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }

}