package com.my.posapp.Oshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.my.posapp.Fragment.HomeFragment;
import com.my.posapp.Fragment.HomeFragmentShop;
import com.my.posapp.Fragment.MyProfileShopFragment;
import com.my.posapp.Fragment.cardFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityHomeOShopBinding;

public class HomeOShopActivity extends AppCompatActivity {

    ActivityHomeOShopBinding binding;
    Fragment fragment;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home_o_shop);

        binding.RRHome.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_blue);
            binding.imgcard.setImageResource(R.drawable.cart);
            binding.imgprofile.setImageResource(R.drawable.profile);

            binding.txtHome.setTextColor(getResources().getColor(R.color.blue));
            binding.txtcard.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtprofile.setTextColor(getResources().getColor(R.color.gray_new));

            fragment = new HomeFragmentShop();
            loadFragment(fragment);

        });

        binding.RRCard.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgcard.setImageResource(R.drawable.card_blue);
            binding.imgprofile.setImageResource(R.drawable.profile);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtcard.setTextColor(getResources().getColor(R.color.blue));
            binding.txtprofile.setTextColor(getResources().getColor(R.color.gray_new));

            fragment = new cardFragment();
            loadFragment(fragment);

        });


        binding.RRProfile.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgcard.setImageResource(R.drawable.cart);
            binding.imgprofile.setImageResource(R.drawable.profile_blue);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtcard.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtprofile.setTextColor(getResources().getColor(R.color.blue));

            fragment = new MyProfileShopFragment();
            loadFragment(fragment);

        });


        fragment = new HomeFragmentShop();
        loadFragment(fragment);

    }


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            
            return;
        }

        binding.imgHome.setImageResource(R.mipmap.home_blue);
        binding.imgcard.setImageResource(R.drawable.cart);
        binding.imgprofile.setImageResource(R.drawable.profile);

        binding.txtHome.setTextColor(getResources().getColor(R.color.blue));
        binding.txtcard.setTextColor(getResources().getColor(R.color.gray_new));
        binding.txtprofile.setTextColor(getResources().getColor(R.color.gray_new));

        fragment = new HomeFragmentShop();
        loadFragment(fragment);

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeshop, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}