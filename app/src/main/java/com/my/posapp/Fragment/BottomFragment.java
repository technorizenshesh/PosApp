package com.my.posapp.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.posapp.R;
import com.my.posapp.act.DeliverActivity;
import com.my.posapp.act.DeliveryManageMent;


public class BottomFragment extends BottomSheetDialogFragment {


    Context context;
    LinearLayout llFaceBook;
    LinearLayout llZola;
    LinearLayout DeliveryManagement;
    private View promptsView;
    private AlertDialog alertDialog;

    public BottomFragment(Context context) {
    this.context=context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.fragment_bottom, (ViewGroup) null);

        llFaceBook = contentView.findViewById(R.id.llFaceBook);
        llZola = contentView.findViewById(R.id.llZola);
        DeliveryManagement = contentView.findViewById(R.id.DeliveryManagement);


        llZola.setOnClickListener(v -> {

            AlertDaliog();

        });

        DeliveryManagement.setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), DeliveryManageMent.class));
        });

        dialog.setContentView(contentView);
        //((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

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
