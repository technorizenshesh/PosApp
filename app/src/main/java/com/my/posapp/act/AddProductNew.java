package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.KiligramAdapter;
import com.my.posapp.databinding.ActivityAddProductNewBinding;
import com.my.posapp.model.AddProductModelCreate;
import com.my.posapp.model.LoginModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductNew extends AppCompatActivity {

    ActivityAddProductNewBinding binding;

    private String code[] ={"Kg","gm"};
    private int flags[]= {R.drawable.locat,R.drawable.locat,R.drawable.locat,R.drawable.locat};

    private SessionManager sessionManager;

    String ProductName="";
    String ProductSKU="";
    String ProductStock="";
    String SellingPrice="";
    String ProductUnitCost="";
    String Weight="";
    String weight_unit="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_product_new);

        sessionManager = new SessionManager(AddProductNew.this);

        KiligramAdapter customAdapter=new KiligramAdapter(AddProductNew.this,flags,code);
        binding.spinnerweightUnit.setAdapter(customAdapter);

       binding.TxtSave.setOnClickListener(v -> {

            ProductName = binding.edtProductName.getText().toString();
            ProductSKU = binding.edtProductSKU.getText().toString();
            ProductStock = binding.edtProductStock.getText().toString();
            SellingPrice = binding.edtProductSellingPrice.getText().toString();
            ProductUnitCost = binding.edtProductUnitCost.getText().toString();
            Weight = binding.edtWeight.getText().toString();


           if(ProductName.equalsIgnoreCase(""))
           {
               Toast.makeText(this, "Please Enter Product Name.", Toast.LENGTH_SHORT).show();

           }else if(ProductSKU.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Product SKU.", Toast.LENGTH_SHORT).show();

           }else if(ProductStock.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Product Stock .", Toast.LENGTH_SHORT).show();

           }else if(SellingPrice.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Selling Price .", Toast.LENGTH_SHORT).show();

           }else if(ProductUnitCost.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Product Unit Cost.", Toast.LENGTH_SHORT).show();

           }else if(Weight.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Product Weight.", Toast.LENGTH_SHORT).show();

           }else if(weight_unit.equalsIgnoreCase("")){

               Toast.makeText(this, "Please Enter Weight Unit.", Toast.LENGTH_SHORT).show();

           }else
           {
               if (sessionManager.isNetworkAvailable()) {

                   binding.progressBar.setVisibility(View.VISIBLE);

                   AddProductMethod();

               }else {

                   Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();

               }
           }

       });

        binding.spinnerweightUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

                weight_unit = code[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

       binding.RRback.setOnClickListener(v -> {
         onBackPressed();
       });
    }

    private void AddProductMethod()
    {
       String User_id = Preference.get(AddProductNew.this,Preference.KEY_USER_ID);

        Call<AddProductModelCreate> call = RetrofitClients.getInstance().getApi()
                .add_quick_product(User_id,ProductName,ProductSKU,ProductStock,SellingPrice,ProductUnitCost,Weight,weight_unit);
        call.enqueue(new Callback<AddProductModelCreate>() {
            @Override
            public void onResponse(Call<AddProductModelCreate> call, Response<AddProductModelCreate> response) {

                binding.progressBar.setVisibility(View.GONE);

                AddProductModelCreate finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1")) {

                    startActivity(new Intent(AddProductNew.this,AllProductListActivity.class));

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddProductNew.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddProductModelCreate> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddProductNew.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}