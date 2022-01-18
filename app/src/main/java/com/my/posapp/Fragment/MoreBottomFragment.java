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

import com.bumptech.glide.Glide;
import com.my.posapp.MainActivity;
import com.my.posapp.Oshop.EditProfile;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.act.CashActivity;
import com.my.posapp.act.ChooseLoginActivity;
import com.my.posapp.act.CustomerActivity;
import com.my.posapp.act.EditProfileManager;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.act.ReportActivity;
import com.my.posapp.databinding.MoreFragmentBinding;
import com.my.posapp.databinding.ProductFragmentBinding;

public class MoreBottomFragment extends Fragment {

    private Fragment fragment;

    MoreFragmentBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.more_fragment, container, false);

        String  User_name = Preference.get(getActivity(),Preference.KEY_User_name);
        String  UserImg = Preference.get(getActivity(),Preference.KEY_USer_img);


        binding.nAme.setText(User_name);

        if(!UserImg.equalsIgnoreCase(""))
        {
            Glide.with(this).load(UserImg).into(binding.imgUser);
        }

        binding.TxtLogout.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
            getActivity().finish();
        });


        binding.RREditProfile.setOnClickListener(v -> {

            Intent i = new Intent(getActivity(), EditProfileManager.class);
            startActivity(i);
        });

        binding.RRReport.setOnClickListener(v -> {

            Intent i = new Intent(getActivity(), ReportActivity.class);
            startActivity(i);

        });

        binding.RRCash.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), CashActivity.class));

        });

        binding.RRCustomer.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), CustomerActivity.class));

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