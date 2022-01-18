package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

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
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        binding.RRHome.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_blue);
            binding.imgOrder.setImageResource(R.mipmap.order_gray);
            binding.imgdelivery.setImageResource(R.mipmap.delivery_gray);
            binding.imgproduct.setImageResource(R.mipmap.product_gray);
            binding.imgMore.setImageResource(R.mipmap.more);

            binding.txtHome.setTextColor(getResources().getColor(R.color.blue));
            binding.txtOrder.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtdelivery.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtproduct.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtMore.setTextColor(getResources().getColor(R.color.gray_new));

            fragment = new HomeFragment();
            loadFragment(fragment);

        });

        binding.RROrder.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgOrder.setImageResource(R.mipmap.order_blue);
            binding.imgdelivery.setImageResource(R.mipmap.delivery_gray);
            binding.imgproduct.setImageResource(R.mipmap.product_gray);
            binding.imgMore.setImageResource(R.mipmap.more);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtOrder.setTextColor(getResources().getColor(R.color.blue));
            binding.txtdelivery.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtproduct.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtMore.setTextColor(getResources().getColor(R.color.gray_new));

            fragment = new OrderFragment();
            loadFragment(fragment);

        });

        binding.RRDelivery.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgOrder.setImageResource(R.mipmap.order_gray);
            binding.imgdelivery.setImageResource(R.mipmap.delivery_blue);
            binding.imgproduct.setImageResource(R.mipmap.product_gray);
            binding.imgMore.setImageResource(R.mipmap.more);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtOrder.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtdelivery.setTextColor(getResources().getColor(R.color.blue));
            binding.txtproduct.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtMore.setTextColor(getResources().getColor(R.color.gray_new));


            fragment = new DeliveryFragment();
            loadFragment(fragment);

        });

        binding.RRProduct.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgOrder.setImageResource(R.mipmap.order_gray);
            binding.imgdelivery.setImageResource(R.mipmap.delivery_gray);
            binding.imgproduct.setImageResource(R.mipmap.product_blue);
            binding.imgMore.setImageResource(R.mipmap.more);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtOrder.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtdelivery.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtproduct.setTextColor(getResources().getColor(R.color.blue));
            binding.txtMore.setTextColor(getResources().getColor(R.color.gray_new));


            fragment = new ProductFragment();
            loadFragment(fragment);

        });

        binding.RRMore.setOnClickListener(v -> {

            binding.imgHome.setImageResource(R.mipmap.home_gray);
            binding.imgOrder.setImageResource(R.mipmap.order_gray);
            binding.imgdelivery.setImageResource(R.mipmap.delivery_gray);
            binding.imgproduct.setImageResource(R.mipmap.product_gray);
            binding.imgMore.setImageResource(R.mipmap.more_blue);

            binding.txtHome.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtOrder.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtdelivery.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtproduct.setTextColor(getResources().getColor(R.color.gray_new));
            binding.txtMore.setTextColor(getResources().getColor(R.color.blue));

            fragment = new MoreBottomFragment();
            loadFragment(fragment);

        });

        fragment = new HomeFragment();
        loadFragment(fragment);

    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        binding.imgHome.setImageResource(R.mipmap.home_blue);
        binding.imgOrder.setImageResource(R.mipmap.order_gray);
        binding.imgdelivery.setImageResource(R.mipmap.delivery_gray);
        binding.imgproduct.setImageResource(R.mipmap.product_gray);
        binding.imgMore.setImageResource(R.mipmap.more);

        binding.txtHome.setTextColor(getResources().getColor(R.color.blue));
        binding.txtOrder.setTextColor(getResources().getColor(R.color.gray_new));
        binding.txtdelivery.setTextColor(getResources().getColor(R.color.gray_new));
        binding.txtproduct.setTextColor(getResources().getColor(R.color.gray_new));
        binding.txtMore.setTextColor(getResources().getColor(R.color.gray_new));

        fragment = new HomeFragment();
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
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }

}