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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.posapp.R;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.act.SignUpActivity;
import com.my.posapp.act.WaitingForPayment;
import com.my.posapp.act.WaitingForPocked;
import com.my.posapp.act.WatingApproval;
import com.my.posapp.databinding.HomeFragmentBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private Fragment fragment;

    HomeFragmentBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);

        binding.llMore.setOnClickListener(v -> {

            BottomFragment bottomSheetFragment= new BottomFragment(getActivity());
            bottomSheetFragment.show(getActivity().getSupportFragmentManager(),"ModalBottomSheet");
        });

        binding.WaitingApporval.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), WatingApproval.class));
        });

        binding.WaitingPayment.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), WaitingForPayment.class));
        });

        binding.WaitingPocked.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), WaitingForPocked.class));

        });

        binding.WaitingShipped.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(),WatingApproval.class));
        });

        binding.WaitingTransit.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(),WatingApproval.class));
        });

        binding.WaitingINComming.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(),WatingApproval.class));
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