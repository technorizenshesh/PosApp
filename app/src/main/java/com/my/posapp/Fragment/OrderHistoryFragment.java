package com.my.posapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.posapp.R;
import com.my.posapp.adapter.OrderHistoryAdapter;
import com.my.posapp.adapter.WishlistAdapter;
import com.my.posapp.databinding.FragmentOrderHistoryBinding;
import com.my.posapp.databinding.FragmentWishListBinding;
import com.my.posapp.model.PaymentModel;

import java.util.ArrayList;

public class OrderHistoryFragment extends Fragment {

    FragmentOrderHistoryBinding binding;

    private ArrayList<PaymentModel> modelList = new ArrayList<>();
    OrderHistoryAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_history, container, false);

        binding.RRBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        setAdapter();

        return binding.getRoot();

    }


    private void setAdapter() {

        this.modelList.add(new PaymentModel("Corn"));
        this.modelList.add(new PaymentModel("Tomotoes"));
        this.modelList.add(new PaymentModel("Tomotoes"));

        mAdapter = new OrderHistoryAdapter(getActivity(),modelList);
        binding.recycleOrderhistory.setHasFixedSize(true);
        binding.recycleOrderhistory.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycleOrderhistory.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new OrderHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, PaymentModel model) {

            }
        });
    }


}