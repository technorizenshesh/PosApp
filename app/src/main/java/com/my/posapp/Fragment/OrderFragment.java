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
import com.my.posapp.act.CreateOrder;
import com.my.posapp.act.DeliveryManageMent;
import com.my.posapp.act.RefoundOrder;
import com.my.posapp.act.SaveOrderList;
import com.my.posapp.act.SellStoreActivity;
import com.my.posapp.act.SignUpActivity;
import com.my.posapp.act.VerificationActivity;
import com.my.posapp.act.WaitingForPayment;
import com.my.posapp.databinding.HomeFragmentBinding;
import com.my.posapp.databinding.OrderFragmentBinding;

public class OrderFragment extends Fragment {

    private Fragment fragment;

     OrderFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.order_fragment, container, false);

        binding.RRCreate.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), CreateOrder.class));
        });

        binding.RRSave.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), SaveOrderList.class));
        });

        binding.RRRefound.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), RefoundOrder.class));
        });

        binding.RROrder.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), WaitingForPayment.class));
        });

        binding.RRdrlibry.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), DeliveryManageMent.class));
        });

        binding.RRStore.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), SellStoreActivity.class));
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