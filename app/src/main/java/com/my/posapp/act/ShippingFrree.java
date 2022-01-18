package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.my.posapp.R;
import com.my.posapp.databinding.ActivityShippingFrreeBinding;

public class ShippingFrree extends AppCompatActivity {

    ActivityShippingFrreeBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;
    String Price="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_shipping_frree);

       binding.RRback.setOnClickListener(v -> {
           onBackPressed();
       });

       binding.txtestimated.setOnClickListener(v -> {
           startActivity(new Intent(ShippingFrree.this,EstimatedFeeActivity.class));
       });

        binding.RRRetailsPrice.setOnClickListener(v -> {

            binding.imgRetailsPrice.setImageResource(R.drawable.blue_circle);
            binding.imgWholePrice.setImageResource(R.drawable.blue_circle_new);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Price= "0";
                    Intent intent=new Intent();
                    intent.putExtra("Price",Price);
                    setResult(103,intent);
                    finish();
                }
            }, 1000);
        });

        binding.RRwholePrice.setOnClickListener(v -> {

            binding.imgRetailsPrice.setImageResource(R.drawable.blue_circle_new);
            binding.imgWholePrice.setImageResource(R.drawable.blue_circle);

            AlertDaliogShippingFree();

        });
    }

    private void AlertDaliogShippingFree() {

        LayoutInflater li;
        EditText edtPr;
        TextView txtSave;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(ShippingFrree.this);
        promptsView = li.inflate(R.layout.alert_product_type_add, null);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(ShippingFrree.this);
        alertDialogBuilder.setView(promptsView);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Price= edtPr.getText().toString();

                if(Price.equalsIgnoreCase(""))
                {

                    Toast.makeText(ShippingFrree.this, "Please Enter Price.", Toast.LENGTH_SHORT).show();

                }else
                {
                    Intent intent=new Intent();
                    intent.putExtra("Price",Price);
                    setResult(103,intent);
                    finish();

                    alertDialog.dismiss();
                }


            }
        });

        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}