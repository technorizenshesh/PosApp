package com.my.posapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.my.posapp.R;
import com.my.posapp.act.AddProduct;
import com.my.posapp.act.AllProductListActivity;
import com.my.posapp.act.StockTrakingActivity;
import com.my.posapp.act.SupplyActivity;
import com.my.posapp.databinding.HomeFragmentBinding;
import com.my.posapp.databinding.ProductFragmentBinding;

public class ProductFragment extends Fragment {

    private Fragment fragment;

     ProductFragmentBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_fragment, container, false);

        binding.llAddProduct.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), AddProduct.class));
        });

        binding.RRProductList.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AllProductListActivity.class));
        });

  binding.RRpurchesOrder.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AllProductListActivity.class));
        });

  binding.RRstocktaking.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), StockTrakingActivity.class));
        });

  binding.RRSupply.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), SupplyActivity.class));
        });

        return binding.getRoot();

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeContainer, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }


}