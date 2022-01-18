package com.my.posapp.act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityCreatePosOrderBinding;
import com.my.posapp.model.AddBrandNameModel;
import com.my.posapp.model.SaveModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePosOrder extends AppCompatActivity {

    ActivityCreatePosOrderBinding binding;
    private View promptsView;
    private AlertDialog alertDialog;

     boolean isProduct=false;
     boolean isCustomer=false;

    String Note="";
    String CustomerID="";
    String ProductId="";
    String RetailsType="Retails";
    int i=1;
    double Discount=0.0;
    String SellingPrice="";

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_create_pos_order);

        sessionManager = new SessionManager(CreatePosOrder.this);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.cross.setOnClickListener(v -> {
            isProduct=false;
            binding.RRProductAdd.setVisibility(View.GONE);
            binding.RRCreateProduct.setVisibility(View.VISIBLE);

        });

        binding.txtSave.setOnClickListener(v -> {

            Validation();
        });

        binding.cross1.setOnClickListener(v ->
        {
            isCustomer=false;
            binding.LlAddCustomer.setVisibility(View.GONE);
            binding.RRAddcustomer.setVisibility(View.VISIBLE);

        });

        binding.RRDiscount.setOnClickListener(v -> {
          //  AlertDaliog();
            AlertDaliogDiscount();
        });

        binding.RRAddcustomer.setOnClickListener(v -> {
            startActivityForResult(new Intent(CreatePosOrder.this, CustomerListActivity.class), 102);
            //startActivity(new Intent(CreatePosOrder.this,AddNewShppied.class));
        });

        binding.RRAddRetailsPrice.setOnClickListener(v -> {

            startActivity(new Intent(CreatePosOrder.this,RetailsPrice.class));
        });

        binding.RRCreateProduct.setOnClickListener(v -> {

            startActivityForResult(new Intent(CreatePosOrder.this, AllProductListActivity.class), 101);

          //  startActivity(new Intent(CreatePosOrder.this,AllProductListActivity.class));

        });

        binding.txtPay.setOnClickListener(v -> {

            startActivity(new Intent(CreatePosOrder.this,PaymentScreen.class));

        });

        binding.RRplus.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            i++;
            // additemListener.addItem(position,i);
            binding.txtQuantity.setText(i + "");

        });

        binding.RRMnus1.setOnClickListener(v -> {
            // String quntity =genericViewHolder.txt_quantity.getText().toString();
            i = Integer.parseInt(i + "");

            if (i > 1) {
                i--;
                // additemListener.addItem(position,i);
                binding.txtQuantity.setText(i + "");
            }
        });

    }

    private void Validation() {

       if(!isProduct)
       {
           Toast.makeText(this, "Please Add Product.", Toast.LENGTH_SHORT).show();

       }else if(!isCustomer)
       {
           Toast.makeText(this, "Please Add Customer.", Toast.LENGTH_SHORT).show();

       }else
       {
           Note=binding.edtNote.getText().toString();

           if (sessionManager.isNetworkAvailable()) {

               binding.progressBar.setVisibility(View.VISIBLE);

               SaveOrderMethod();

           }else {

               Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
           }

       }

    }

   private void AlertDaliog() {

        LayoutInflater li;
        LinearLayout RRcancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreatePosOrder.this);
        promptsView = li.inflate(R.layout.alert_discount, null);
        RRcancel = (LinearLayout) promptsView.findViewById(R.id.RRcancel);
        alertDialogBuilder = new AlertDialog.Builder(CreatePosOrder.this);
        alertDialogBuilder.setView(promptsView);

        RRcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    private void AlertDaliogDiscount() {
        LayoutInflater li;
        EditText edtPr;
        TextView txtSave;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(CreatePosOrder.this);
        promptsView = li.inflate(R.layout.alert_product_type_add, null);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(CreatePosOrder.this);
        alertDialogBuilder.setView(promptsView);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Peentage = edtPr.getText().toString();
                int Peentag = Integer.parseInt(Peentage);

                if (!SellingPrice.equalsIgnoreCase("")) {
                    double amount = Double.parseDouble(SellingPrice);
                    Discount = (amount / 100.0f) * Peentag;
                    double NEwAmt = amount-Discount;

                    binding.txtDiscount.setText(Discount + "");

                    binding.txtEstimate.setText(NEwAmt + "");


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            isProduct =true;
            binding.RRCreateProduct.setVisibility(View.GONE);
            binding.RRProductAdd.setVisibility(View.VISIBLE);

            String Name = data.getStringExtra("Name");
            SellingPrice = data.getStringExtra("SellingPrice");
            ProductId = data.getStringExtra("ProductId");
            binding.txtName.setText(Name);
            binding.txtPrice.setText(SellingPrice);
             binding.txtSubTotal.setText(SellingPrice);
            binding.txtQuantity.setText("1");

            binding.txtEstimate.setText(SellingPrice + "");

        } else if (requestCode == 102) {

            isCustomer =true;

            binding.LlAddCustomer.setVisibility(View.VISIBLE);
            binding.RRAddcustomer.setVisibility(View.GONE);

            String CustomerName = data.getStringExtra("CustomerName");
            CustomerID = data.getStringExtra("CustomerID");
            String Phone = data.getStringExtra("Phone");
            String Address = data.getStringExtra("Address");
            String Area = data.getStringExtra("Area");
            String SubDisk = data.getStringExtra("SubDisk");

            binding.txtCustomerName.setText(CustomerName);
            binding.txtPHone.setText("- " + Phone);
            binding.txtAddress.setText(Address + "," + Area + "," + SubDisk + " ");
            //binding.txtAddress.setText(Address+"");


        }else if (requestCode == 103) {
            String Price = data.getStringExtra("Price");
           // binding.DeliveryFee.setText("" + Price);

        } else if (requestCode == 104) {
            RetailsType = data.getStringExtra("Type");
            binding.txtType.setText("" + RetailsType);
        }

    }


    private void SaveOrderMethod()
    {
        String User_id = Preference.get(CreatePosOrder.this,Preference.KEY_USER_ID);

        Call<SaveModel> call = RetrofitClients.getInstance().getApi()
                .save_order(User_id,CustomerID,ProductId,i+"",SellingPrice,"knn",Discount+"",RetailsType,Note);
        call.enqueue(new Callback<SaveModel>() {
            @Override
            public void onResponse(Call<SaveModel> call, Response<SaveModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                SaveModel finallyPr = response.body();

                String status = finallyPr.status;
                String Message = finallyPr.message;

                if (status.equalsIgnoreCase("1"))
                {
                    Toast.makeText(CreatePosOrder.this, ""+Message, Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(CreatePosOrder.this,HomeActivity.class));
                    finish();

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(CreatePosOrder.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<SaveModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(CreatePosOrder.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}