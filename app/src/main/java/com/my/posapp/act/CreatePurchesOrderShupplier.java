package com.my.posapp.act;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.my.posapp.Fragment.BottomCreatePurchesMoreFragment;
import com.my.posapp.Fragment.BottomShippingMethodFragment;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCreatePurchesOrderBinding;
import com.my.posapp.databinding.ActivityCreatePurchesOrderShupplierBinding;
import com.my.posapp.model.GetCreatePurchesShupplier;
import com.my.posapp.model.SaveModel;
import com.my.posapp.utils.RetrofitClients;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePurchesOrderShupplier extends AppCompatActivity {

    ActivityCreatePurchesOrderShupplierBinding binding;
    String SellingPrice = "";
    String CustomerID = "";
    String ProductId = "";

    private View promptsView;
    private AlertDialog alertDialog;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_create_purches_order_shupplier);

        binding.RRCreateProduct.setOnClickListener(v -> {
            startActivityForResult(new Intent(CreatePurchesOrderShupplier.this, AllProductListActivity.class), 101);
        });

        binding.cross.setOnClickListener(v -> {

            binding.RRProductAdd.setVisibility(View.GONE);
            binding.RRCreateProduct.setVisibility(View.VISIBLE);

        });

        binding.RRCustomer.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreatePurchesOrderShupplier.this, CustomerListActivity.class), 102);

        });

        binding.RRDiscount.setOnClickListener(v -> {

            AlertDaliogDiscount();

        });

        binding.RRProcurement.setOnClickListener(v -> {

            AlertDaliogPurchesCost();

        });

        binding.imgMore.setOnClickListener(v -> {

            BottomCreatePurchesMoreFragment bottomSheetFragment = new BottomCreatePurchesMoreFragment(CreatePurchesOrderShupplier.this);
            bottomSheetFragment.show(getSupportFragmentManager(), "ModalBottomSheet");

        });

        binding.RRplus.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            i++;
            // additemListener.addItem(position,i);
            binding.TxtQuantity.setText(i + "");
            binding.txtQuantity.setText(i + "");

        });

        binding.RRMnus1.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            if (i > 1) {
                i--;
                //  additemListener.addItem(position,i);
                binding.TxtQuantity.setText(i + "");
                binding.txtQuantity.setText(i + "");
            }
        });

        binding.CreateOrder.setOnClickListener(v -> {

            startActivity(new Intent(CreatePurchesOrderShupplier.this,ApprovedOrder.class));

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
            ProductId = data.getStringExtra("ProductId");
            binding.txtName.setText(Name);
            binding.txtPrice.setText(SellingPrice);
            binding.txtSubTotal.setText(SellingPrice);
            binding.txtQuantity.setText("1");
            binding.TxtQuantity.setText("1");

        } else if (requestCode == 102) {

          //  binding.LlAddCustomer.setVisibility(View.VISIBLE);
          //  binding.RRAddcustomer.setVisibility(View.GONE);

            CustomerID = data.getStringExtra("CustomerID");
            String CustomerName = data.getStringExtra("CustomerName");
            String Phone = data.getStringExtra("Phone");
            String Address = data.getStringExtra("Address");
            String Area = data.getStringExtra("Area");
            String SubDisk = data.getStringExtra("SubDisk");

            binding.txtName.setText(CustomerName);

        } else if (requestCode == 103) {
            String Price = data.getStringExtra("Price");
           // binding.DeliveryFee.setText("" + Price);

        } else if (requestCode == 104) {
            String Type = data.getStringExtra("Type");
            //binding.txtType.setText("" + Type);
        }
    }

    private void AlertDaliogDiscount() {

        LayoutInflater li;
        EditText edtPr;
        TextView txtSave;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreatePurchesOrderShupplier.this);
        promptsView = li.inflate(R.layout.alert_product_type_add, null);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(CreatePurchesOrderShupplier.this);
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

    private void AlertDaliogPurchesCost() {

        LayoutInflater li;
        EditText edtPr;
        TextView txtSave;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreatePurchesOrderShupplier.this);
        promptsView = li.inflate(R.layout.alert_purches_cost, null);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(CreatePurchesOrderShupplier.this);
        alertDialogBuilder.setView(promptsView);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String COst =edtPr.getText().toString();
                binding.COstFre.setText("" + COst);
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

    private void SaveOrderMethod()
    {
        String User_id = Preference.get(CreatePurchesOrderShupplier.this,Preference.KEY_USER_ID);

        Call<GetCreatePurchesShupplier> call = RetrofitClients.getInstance().getApi()
                .add_purchase_order(User_id,"",CustomerID,ProductId,"1","1",SellingPrice,
                "","","","","");
        call.enqueue(new Callback<GetCreatePurchesShupplier>() {
            @Override
            public void onResponse(Call<GetCreatePurchesShupplier> call, Response<GetCreatePurchesShupplier> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetCreatePurchesShupplier finallyPr = response.body();

                String status = finallyPr.status;
                String Message = finallyPr.message;

                if (status.equalsIgnoreCase("1"))
                {
                    Toast.makeText(CreatePurchesOrderShupplier.this, ""+Message, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(CreatePurchesOrderShupplier.this,HomeActivity.class));
                    finish();

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(CreatePurchesOrderShupplier.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetCreatePurchesShupplier> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(CreatePurchesOrderShupplier.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}