package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.my.posapp.Fragment.FinaceReportFragment;
import com.my.posapp.Fragment.HomeFragment;
import com.my.posapp.Fragment.InveraryReportFragment;
import com.my.posapp.Fragment.SalesReportFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityReportBinding;

public class ReportActivity extends AppCompatActivity {

    ActivityReportBinding binding;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_report);

        fragment = new SalesReportFragment();
        loadFragment(fragment);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.txtSales.setOnClickListener(v -> {

            binding.txtSales.setTextColor(getResources().getColor(R.color.blue));
            binding.txtInventory.setTextColor(getResources().getColor(R.color.natural_gray));
            binding.txtFinancy.setTextColor(getResources().getColor(R.color.natural_gray));


            binding.viewSales.setBackgroundResource(R.color.blue);
            binding.viewINVENTORY.setBackgroundResource(R.color.natural_gray);
            binding.viewFINANCE.setBackgroundResource(R.color.natural_gray);

            fragment = new SalesReportFragment();
            loadFragment(fragment);
        });

        binding.txtInventory.setOnClickListener(v -> {

            binding.viewSales.setBackgroundResource(R.color.natural_gray);
            binding.viewINVENTORY.setBackgroundResource(R.color.blue);
            binding.viewFINANCE.setBackgroundResource(R.color.natural_gray);

            binding.txtSales.setTextColor(getResources().getColor(R.color.natural_gray));
            binding.txtInventory.setTextColor(getResources().getColor(R.color.blue));
            binding.txtFinancy.setTextColor(getResources().getColor(R.color.natural_gray));


            fragment = new InveraryReportFragment();
            loadFragment(fragment);
        });

        binding.txtFinancy.setOnClickListener(v -> {

            binding.viewSales.setBackgroundResource(R.color.natural_gray);
            binding.viewINVENTORY.setBackgroundResource(R.color.natural_gray);
            binding.viewFINANCE.setBackgroundResource(R.color.blue);

            binding.txtSales.setTextColor(getResources().getColor(R.color.natural_gray));
            binding.txtInventory.setTextColor(getResources().getColor(R.color.natural_gray));
            binding.txtFinancy.setTextColor(getResources().getColor(R.color.blue));

            fragment = new FinaceReportFragment();
            loadFragment(fragment);
        });
    }


    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_ReportContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }
}