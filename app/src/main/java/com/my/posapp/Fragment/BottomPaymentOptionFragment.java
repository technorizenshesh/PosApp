package com.my.posapp.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.posapp.R;
import com.my.posapp.act.LoginActivity;
import com.my.posapp.act.SignUpActivity;
import com.my.posapp.act.WaitingPayLeter;


public class BottomPaymentOptionFragment extends BottomSheetDialogFragment {


    Context context;

    public BottomPaymentOptionFragment(Context context) {
    this.context=context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.fragment_payment_option, (ViewGroup) null);
        dialog.setContentView(contentView);
        //((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

       TextView txtPayLeter=contentView.findViewById(R.id.txtPayLeter);

        txtPayLeter.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), WaitingPayLeter.class));

        });
    }

}
