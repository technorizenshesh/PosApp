package com.my.posapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.my.posapp.R;
import com.my.posapp.databinding.FragmentProductDetailsShopBinding;

public class ProductDeatislShopFragment extends Fragment {

    FragmentProductDetailsShopBinding binding;
    Fragment fragment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details_shop, container, false);


        binding.RRBack.setOnClickListener(v -> {

            getActivity().onBackPressed();

        });

        binding.txtAddCard.setOnClickListener(v -> {

            fragment = new cardFragment();
            loadFragment(fragment);

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