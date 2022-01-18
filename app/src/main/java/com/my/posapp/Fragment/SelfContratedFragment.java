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
import com.my.posapp.act.AddNewShppied;
import com.my.posapp.act.HomeActivity;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.databinding.IntregratedFragmentBinding;
import com.my.posapp.databinding.SelfContratedFragmentBinding;

public class SelfContratedFragment extends Fragment {

    private Fragment fragment;

     SelfContratedFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.self_contrated_fragment, container, false);

        binding.txtAddNewShipper.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AddNewShppied.class));
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