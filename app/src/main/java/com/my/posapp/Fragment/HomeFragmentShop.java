package com.my.posapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.posapp.R;
import com.my.posapp.act.AddProduct;
import com.my.posapp.act.CreateOrder;
import com.my.posapp.act.CreatePaymentOrder;
import com.my.posapp.act.CreatePurchesOrder;
import com.my.posapp.act.FilterSearchShopOshop;
import com.my.posapp.act.FilterSetting;
import com.my.posapp.act.WaitingForPayment;
import com.my.posapp.act.WaitingForPocked;
import com.my.posapp.act.WaitingPaymentDetails;
import com.my.posapp.act.WatingApproval;
import com.my.posapp.adapter.NearByOshopAdapter;
import com.my.posapp.adapter.ShopByCategoryAdapter;
import com.my.posapp.adapter.WaitingForPaymentAdapter;
import com.my.posapp.databinding.HomeFragmentBinding;
import com.my.posapp.databinding.HomeFragmentShopBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class HomeFragmentShop extends Fragment {

    HomeFragmentShopBinding binding;
    private ArrayList<PaymentModel> modelList = new ArrayList<>();
    private ArrayList<PaymentModel> modelListNew = new ArrayList<>();
    ShopByCategoryAdapter mAdapter;
    NearByOshopAdapter mAdapterNearBy;
    Fragment fragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment_shop, container, false);

        binding.imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), FilterSearchShopOshop.class));

            }
        });

        
        setAdapter();

        setAdapterNearByShop();

        return binding.getRoot();

    }

    private void setAdapter() {

        modelList.clear();

        this.modelList.add(new PaymentModel("Corn"));
        this.modelList.add(new PaymentModel("Tomotoes"));
        this.modelList.add(new PaymentModel("Tomotoes"));
        this.modelList.add(new PaymentModel("Tomotoes"));

        mAdapter = new ShopByCategoryAdapter(getActivity(),modelList);

        binding.recyclerCustomersall.setHasFixedSize(true);

        binding.recyclerCustomersall.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));

        binding.recyclerCustomersall.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ShopByCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

            }
        });
    }

    private void setAdapterNearByShop() {

        modelListNew.clear();

        this.modelListNew.add(new PaymentModel("Corn"));
        this.modelListNew.add(new PaymentModel("Tomotoes"));

        mAdapterNearBy = new NearByOshopAdapter(getActivity(),modelListNew);

        binding.recyclerNearShop.setHasFixedSize(true);

        binding.recyclerNearShop.setLayoutManager(new GridLayoutManager(getActivity(),2));

        binding.recyclerNearShop.setAdapter(mAdapterNearBy);

        mAdapterNearBy.SetOnItemClickListener(new NearByOshopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

                fragment = new ProductDeatislShopFragment();
                loadFragment(fragment);
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeshop, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }

}