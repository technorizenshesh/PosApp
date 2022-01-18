package com.my.posapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.act.AddProduct;
import com.my.posapp.act.CreateOrder;
import com.my.posapp.act.CreatePaymentOrder;
import com.my.posapp.act.CreatePosOrder;
import com.my.posapp.act.CreatePurchesOrder;
import com.my.posapp.act.LookingShippingFree;
import com.my.posapp.act.PurchesOrderActivity;
import com.my.posapp.act.WaitingForPayment;
import com.my.posapp.act.WaitingForPocked;
import com.my.posapp.act.WatingApproval;
import com.my.posapp.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private Fragment fragment;

    HomeFragmentBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);

        binding.llMore.setOnClickListener(v -> {

            BottomFragment bottomSheetFragment = new BottomFragment(getActivity());
            bottomSheetFragment.show(getActivity().getSupportFragmentManager(), "ModalBottomSheet");
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
            startActivity(new Intent(getActivity(), WatingApproval.class));
        });

        binding.WaitingTransit.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), WatingApproval.class));
        });

        binding.WaitingINComming.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), WatingApproval.class));
        });


        binding.LLCreateOrder.setOnClickListener(v -> {
            Preference.save(getActivity(),Preference.KEY_Product_add,"0");
            startActivity(new Intent(getActivity(), CreateOrder.class));
        });

        binding.LlCreateOrderPos.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), CreatePosOrder.class));
        });

        binding.llAddProduct.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AddProduct.class));
        });

        binding.LLCreatePurchesOrder.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), PurchesOrderActivity.class));
        });

        binding.LLCreatePayment.setOnClickListener(v -> {
           // startActivity(new Intent(getActivity(), CreatePaymentOrder.class));
            startActivity(new Intent(getActivity(), PurchesOrderActivity.class));
        });

 binding.llShippingFree.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), LookingShippingFree.class));
        });


        binding.llFaceBook.setOnClickListener(v -> {

            AlertDaliog();
        });

        binding.llFaceBook.setOnClickListener(v -> {

            AlertDaliog();
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


    private void AlertDaliog() {
        LayoutInflater li;
        TextView txtExit;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(getActivity());
        promptsView = li.inflate(R.layout.alert_dailoge_face, null);
        txtExit = (TextView) promptsView.findViewById(R.id.txtExit);
        alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptsView);

        txtExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}