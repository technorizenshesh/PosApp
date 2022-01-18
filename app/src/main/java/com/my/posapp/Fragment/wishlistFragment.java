package com.my.posapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.posapp.Oshop.CheckOutDelivery;
import com.my.posapp.R;
import com.my.posapp.adapter.CardRecyclerViewAdapter;
import com.my.posapp.adapter.WishlistAdapter;
import com.my.posapp.databinding.FragmentCardBinding;
import com.my.posapp.databinding.FragmentWishListBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class wishlistFragment extends Fragment {

    FragmentWishListBinding binding;

    private ArrayList<PaymentModel> modelListwishlist = new ArrayList<>();
    WishlistAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wish_list, container, false);

        binding.RRBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        setAdapter();

        return binding.getRoot();

    }


    private void setAdapter() {

        this.modelListwishlist.add(new PaymentModel("Corn"));
        this.modelListwishlist.add(new PaymentModel("Tomotoes"));

        mAdapter = new WishlistAdapter(getActivity(),modelListwishlist);
        binding.recyclewishlist.setHasFixedSize(true);
        binding.recyclewishlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclewishlist.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new WishlistAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

            }
        });
    }


}