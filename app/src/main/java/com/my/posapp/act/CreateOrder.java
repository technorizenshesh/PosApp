package com.my.posapp.act;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.posapp.Fragment.BottomMoreCreateFragment;
import com.my.posapp.Fragment.BottomShippingMethodFragment;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCreateOrderBinding;

public class CreateOrder extends AppCompatActivity {

    ActivityCreateOrderBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;
    int i = 1;
    String SellingPrice = "";
    String CustomerID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_order);


        binding.cross.setOnClickListener(v -> {

            binding.RRProductAdd.setVisibility(View.GONE);
            binding.RRCreateProduct.setVisibility(View.VISIBLE);

        });

        binding.cross1.setOnClickListener(v ->
        {

            binding.LlAddCustomer.setVisibility(View.GONE);
            binding.RRAddcustomer.setVisibility(View.VISIBLE);

        });


        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });

        binding.RRShippingFree.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreateOrder.this, ShippingFrree.class), 103);

            //startActivity(new Intent(CreateOrder.this, ShippingFrree.class));
        });

        binding.txtCoupan.setOnClickListener(v -> {

            startActivity(new Intent(CreateOrder.this, ApplyCouapnActivity.class));

        });

        binding.RRDiscount.setOnClickListener(v -> {

            AlertDaliogDiscount();

        });

        binding.txtChoosePayment.setOnClickListener(v ->
        {
            //startActivity(new Intent(CreateOrder.this, CreatePaymentOrder.class));

           /* BottomPaymentOptionFragment bottomSheetFragment = new BottomPaymentOptionFragment(CreateOrder.this);
            bottomSheetFragment.show(getSupportFragmentManager(), "ModalBottomSheet");*/
        });

        binding.CreateOrder.setOnClickListener(v -> {

            BottomShippingMethodFragment bottomSheetFragment = new BottomShippingMethodFragment(CreateOrder.this);
            bottomSheetFragment.show(getSupportFragmentManager(), "ModalBottomSheet");
            //AlertDaliogChoosePickup();
        });

        binding.imgMore.setOnClickListener(v -> {

            BottomMoreCreateFragment bottomSheetFragment = new BottomMoreCreateFragment(CreateOrder.this);
            bottomSheetFragment.show(getSupportFragmentManager(), "ModalBottomSheet");
        });


        binding.RRAddcustomer.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreateOrder.this, CustomerListActivity.class), 102);
            //  startActivity(new Intent(CreateOrder.this, CustomerListActivity.class));

        });

        binding.RRAddRetailsPrice.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreateOrder.this, RetailsPrice.class), 104);

           // startActivity(new Intent(CreateOrder.this, RetailsPrice.class));

        });

        binding.RRCreateProduct.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreateOrder.this, AllProductListActivity.class), 101);

            //  startActivity(new Intent(CreateOrder.this, AllProductListActivity.class));

        });

        binding.RRplus.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            i++;
            // additemListener.addItem(position,i);
            binding.txtQuantity.setText(i + "");
            binding.txtQuantity.setText(i + "");

        });

        binding.RRMnus1.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            if (i > 1) {
                i--;
                //  additemListener.addItem(position,i);
                binding.txtQuantity.setText(i + "");
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            binding.RRCreateProduct.setVisibility(View.GONE);
            binding.RRProductAdd.setVisibility(View.VISIBLE);

            String Name = data.getStringExtra("Name");
            SellingPrice = data.getStringExtra("SellingPrice");
            binding.txtName.setText(Name);
            binding.txtPrice.setText(SellingPrice);
            binding.txtSubTotal.setText(SellingPrice);
            binding.txtQuantity.setText("1");

        } else if (requestCode == 102) {

            binding.LlAddCustomer.setVisibility(View.VISIBLE);
            binding.RRAddcustomer.setVisibility(View.GONE);

            CustomerID = data.getStringExtra("CustomerID");
            String CustomerName = data.getStringExtra("CustomerName");
            String Phone = data.getStringExtra("Phone");
            String Address = data.getStringExtra("Address");
            String Area = data.getStringExtra("Area");
            String SubDisk = data.getStringExtra("SubDisk");

            binding.txtCustomerName.setText(CustomerName);
            binding.txtPHone.setText("- " + Phone);
            binding.txtAddress.setText(Address + "," + Area + "," + SubDisk + " ");
            //binding.txtAddress.setText(Address+"");


        } else if (requestCode == 103) {
            String Price = data.getStringExtra("Price");
            binding.DeliveryFee.setText("" + Price);

        } else if (requestCode == 104) {
            String Type = data.getStringExtra("Type");
            binding.txtType.setText("" + Type);
        }
    }

    private void AlertDaliogDiscount() {

        LayoutInflater li;
        EditText edtPr;
        TextView txtSave;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreateOrder.this);
        promptsView = li.inflate(R.layout.alert_product_type_add, null);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(CreateOrder.this);
        alertDialogBuilder.setView(promptsView);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Peentage = edtPr.getText().toString();
                int Peentag = Integer.parseInt(Peentage);

                if (!SellingPrice.equalsIgnoreCase("")) {
                    double amount = Double.parseDouble(SellingPrice);
                    double res = (amount / 100.0f) * Peentag;
                    binding.txtDisCount.setText(res + "");
                } else {
                    Toast.makeText(getApplicationContext(), "Amount cannot be empty", Toast.LENGTH_SHORT).show();
                }
                alertDialog.dismiss();
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

    private void AlertDaliogChoosePickup() {

        LayoutInflater li;
        TextView txtaddress;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreateOrder.this);
        promptsView = li.inflate(R.layout.fragment_bottom_more_option, null);
        txtaddress = (TextView) promptsView.findViewById(R.id.txtaddress);
        alertDialogBuilder = new AlertDialog.Builder(CreateOrder.this);
        alertDialogBuilder.setView(promptsView);

        txtaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
                AlertDaliogArea();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }


    private void AlertDaliogArea() {

        LayoutInflater li;
        LinearLayout RRArea;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreateOrder.this);
        promptsView = li.inflate(R.layout.alert_choosearea, null);
        RRArea = (LinearLayout) promptsView.findViewById(R.id.RRArea);
        alertDialogBuilder = new AlertDialog.Builder(CreateOrder.this);
        alertDialogBuilder.setView(promptsView);

        RRArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CreateOrder.this, "Order Create", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateOrder.this, HomeActivity.class));

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        // alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }


}