package com.my.posapp.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.posapp.R;


public class BottomShippingMethodFragment extends BottomSheetDialogFragment {


    Context context;

    public BottomShippingMethodFragment(Context context) {
    this.context=context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.fragment_shipping_method, (ViewGroup) null);
        dialog.setContentView(contentView);
        //((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

    }

}
