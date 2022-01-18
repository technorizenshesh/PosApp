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

import com.my.posapp.Oshop.CheckOutAddress;
import com.my.posapp.Oshop.EditProfile;
import com.my.posapp.R;
import com.my.posapp.act.ChooseLoginActivity;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.databinding.MyProfileFrgmentBinding;

public class MyProfileShopFragment extends Fragment {

    private Fragment fragment;

    MyProfileFrgmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_profile_frgment, container, false);

        binding.RREditProfile.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), EditProfile.class));

        });

        binding.RRShippingAddress.setOnClickListener(v -> {

            fragment = new ShiipingAddressShopFragment();
            loadFragment(fragment);

        });

        binding.RRWishlist.setOnClickListener(v -> {

            fragment = new wishlistFragment();
            loadFragment(fragment);

        });

        binding.RROrderHistory.setOnClickListener(v -> {

            fragment = new OrderHistoryFragment();
            loadFragment(fragment);

        });

        binding.RRtrackOrder.setOnClickListener(v -> {

            fragment = new TrackOrderFragment();
            loadFragment(fragment);

        });

        binding.RRLogut.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), ChooseLoginActivity.class));
        });

        return binding.getRoot();

    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_homeshop, fragment);
        transaction.addToBackStack("home");
        transaction.commit();
    }

}