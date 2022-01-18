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
import com.my.posapp.act.DebtReconciliationActtivity;
import com.my.posapp.act.DeliveryManageMent;
import com.my.posapp.act.HomeActivity;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.act.LookingShippingFree;
import com.my.posapp.act.ShippedActivity;
import com.my.posapp.databinding.DeliveryFragmentBinding;
import com.my.posapp.databinding.HomeFragmentBinding;

public class DeliveryFragment extends Fragment {

    private Fragment fragment;

    DeliveryFragmentBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.delivery_fragment, container, false);


        binding.RRLookup.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), LookingShippingFree.class));

        });

        binding.RRShipper.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ShippedActivity.class));
        });

        binding.RRDelivery.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), DeliveryManageMent.class));
        });

        binding.RRReconcilliation.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), DebtReconciliationActtivity.class));
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