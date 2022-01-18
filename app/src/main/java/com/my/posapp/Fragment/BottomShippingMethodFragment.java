package com.my.posapp.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.posapp.R;
import com.my.posapp.act.CreateOrder;
import com.my.posapp.act.CustomerListActivity;
import com.my.posapp.act.HomeActivity;
import com.my.posapp.act.ShippedActivity;
import com.my.posapp.act.ShippingFrree;
import com.my.posapp.act.WaitingForPayment;
import com.my.posapp.act.WaitingPaymentDetails;
import com.my.posapp.act.WatingApproval;
import com.my.posapp.databinding.FragmentShippingMethodBinding;


public class BottomShippingMethodFragment extends BottomSheetDialogFragment {


    Context context;
    FragmentShippingMethodBinding binding;

    private View promptsView;
    private AlertDialog alertDialog;

    public BottomShippingMethodFragment(Context context) {
    this.context=context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupDialog(Dialog dialog, int style) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        binding= DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shipping_method, null, false);

        binding.txtForword.setOnClickListener(v -> {

            //AlertDaliogCustomer();
            dialog.dismiss();
        });

        binding.txtcallshipper.setOnClickListener(v -> {

         //   AlertDaliogCustomer();
            dialog.dismiss();

        });

        binding.txtpickUpAtStore.setOnClickListener(v -> {

           // AlertDaliogCustomer();
            dialog.dismiss();

        });

        dialog.setContentView(binding.getRoot());

    }

    private void AlertDaliogCustomer() {

        Activity activity = getActivity();


        LayoutInflater li;
        TextView txtExit1;
        TextView txtAdd1;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(getActivity());
        promptsView = li.inflate(R.layout.alert_warning, null);
        txtExit1 = (TextView) promptsView.findViewById(R.id.txtExit1);
        txtAdd1 = (TextView) promptsView.findViewById(R.id.txtAdd1);
        alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptsView);

        txtExit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        txtAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isAdded() && activity != null)
                {
                    Toast.makeText(activity, "Order Create", Toast.LENGTH_SHORT).show();
                 //  startActivity(new Intent(activity.getApplicationContext(),CustomerListActivity.class));
                }
                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        // alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

}
