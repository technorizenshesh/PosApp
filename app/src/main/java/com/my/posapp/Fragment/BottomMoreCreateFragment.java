package com.my.posapp.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.posapp.MainActivity;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.act.ChooseLoginActivity;
import com.my.posapp.databinding.FragmentChangeOrderMethodBinding;


public class BottomMoreCreateFragment extends BottomSheetDialogFragment {


    Context context;

    FragmentChangeOrderMethodBinding binding;

    public BottomMoreCreateFragment(Context context) {
        this.context = context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupDialog(Dialog dialog, int style) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        binding=DataBindingUtil.inflate(layoutInflater, R.layout.fragment_change_order_method, null, false);

       String Value = Preference.get(getActivity(),Preference.KEY_Value);

       if(Value.equalsIgnoreCase("0"))
       {
           binding.llOne.setVisibility(View.VISIBLE);
           binding.llTwo.setVisibility(View.GONE);
           binding.llTHree.setVisibility(View.GONE);

           binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.blue));
           binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.black));
           binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.black));


       }else if(Value.equalsIgnoreCase("1"))
       {
           binding.llOne.setVisibility(View.VISIBLE);
           binding.llTwo.setVisibility(View.GONE);
           binding.llTHree.setVisibility(View.GONE);

           binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.blue));
           binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.black));
           binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.black));


       }else if(Value.equalsIgnoreCase("2"))
       {

           binding.llOne.setVisibility(View.GONE);
           binding.llTwo.setVisibility(View.VISIBLE);
           binding.llTHree.setVisibility(View.GONE);

           binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.black));
           binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.blue));
           binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.black));


       }else if(Value.equalsIgnoreCase("3"))
       {

           binding.llOne.setVisibility(View.GONE);
           binding.llTwo.setVisibility(View.GONE);
           binding.llTHree.setVisibility(View.VISIBLE);

           binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.black));
           binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.black));
           binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.blue));


       }

        binding.txtCreate.setOnClickListener(v -> {

            Preference.save(getActivity(),Preference.KEY_Value,"1");

            binding.llOne.setVisibility(View.VISIBLE);
            binding.llTwo.setVisibility(View.GONE);
            binding.llTHree.setVisibility(View.GONE);

            binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.blue));
            binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.black));
            binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.black));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    dialog.dismiss();
                }
            }, 1000);


        });

        binding.txtApprove.setOnClickListener(v -> {

            Preference.save(getActivity(),Preference.KEY_Value,"2");

            binding.llOne.setVisibility(View.GONE);
            binding.llTwo.setVisibility(View.VISIBLE);
            binding.llTHree.setVisibility(View.GONE);

            binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.black));
            binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.blue));
            binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.black));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    dialog.dismiss();
                }
            }, 1000);

        });

        binding.txtDelivery.setOnClickListener(v -> {

            Preference.save(getActivity(),Preference.KEY_Value,"3");

            binding.llOne.setVisibility(View.GONE);
            binding.llTwo.setVisibility(View.GONE);
            binding.llTHree.setVisibility(View.VISIBLE);

            binding.txtCreate.setTextColor(ContextCompat.getColor(context, R.color.black));
            binding.txtApprove.setTextColor(ContextCompat.getColor(context, R.color.black));
            binding.txtDelivery.setTextColor(ContextCompat.getColor(context, R.color.blue));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    dialog.dismiss();
                }
            }, 1000);
        });

        dialog.setContentView(binding.getRoot());
    }

}
