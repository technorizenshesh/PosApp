package com.my.posapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.my.posapp.Oshop.EditProfile;
import com.my.posapp.R;
import com.my.posapp.databinding.MyProfileFrgmentBinding;
import com.my.posapp.databinding.ShippingAddressFrgmentBinding;

public class ShiipingAddressShopFragment extends Fragment {

    private Fragment fragment;

    ShippingAddressFrgmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.shipping_address_frgment, container, false);

        return binding.getRoot();

    }

}