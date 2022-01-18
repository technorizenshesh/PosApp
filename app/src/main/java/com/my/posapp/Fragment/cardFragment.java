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
import com.my.posapp.adapter.ShopByCategoryAdapter;
import com.my.posapp.databinding.FragmentCardBinding;
import com.my.posapp.databinding.FragmentProductDetailsShopBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class cardFragment extends Fragment {

    FragmentCardBinding binding;

    private ArrayList<PaymentModel> modelList = new ArrayList<>();
    CardRecyclerViewAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false);

        binding.RRBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.txtCheckOut.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), CheckOutDelivery.class));

        });

        setAdapter();

        return binding.getRoot();

    }


    private void setAdapter() {

        this.modelList.add(new PaymentModel("Corn"));
        this.modelList.add(new PaymentModel("Tomotoes"));

        mAdapter = new CardRecyclerViewAdapter(getActivity(),modelList);
        binding.recyclerall.setHasFixedSize(true);
        binding.recyclerall.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerall.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new CardRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

            }
        });
    }


}