package com.my.posapp.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

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
import com.my.posapp.adapter.AllCustomerListAdapter;
import com.my.posapp.adapter.AllPRoductTypeListAdapter;
import com.my.posapp.databinding.ActivityProductTypeBinding;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.model.GetUserProducType;
import com.my.posapp.model.ProductTypeModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductTypeActivity extends AppCompatActivity {

    ActivityProductTypeBinding binding;
    private AllPRoductTypeListAdapter mAdapter;
    ArrayList<GetUserProducType.Result> modelList=new ArrayList<GetUserProducType.Result>();

    private SessionManager sessionManager;

    private View promptsView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_product_type);

        sessionManager = new SessionManager(ProductTypeActivity.this);


        binding.RRAddProductType.setOnClickListener(v -> {

            AlertDaliogAdd();

        });

        if (sessionManager.isNetworkAvailable()) {

            binding.progressBar.setVisibility(View.VISIBLE);

            GetAllProductTypeMethod();

        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }

    }


    private void setAdapter(ArrayList<GetUserProducType.Result> modelList) {

        //this.modelList.add(new PaymentModel("Corn"));
        mAdapter = new AllPRoductTypeListAdapter(ProductTypeActivity.this,modelList);
        binding.recyclerProductType.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductTypeActivity.this);
        binding.recyclerProductType.setLayoutManager(linearLayoutManager);
        binding.recyclerProductType.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AllPRoductTypeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetUserProducType.Result model) {

               String ProductType= model.getProductType().toString();
                Intent intent=new Intent(ProductType);
                intent.putExtra("Type",ProductType);
                setResult(101,intent);
                finish();
            }
        });
    }

    private void GetAllProductTypeMethod()
    {
        String User_id = Preference.get(ProductTypeActivity.this,Preference.KEY_USER_ID);

        Call<GetUserProducType> call = RetrofitClients.getInstance().getApi()
                .get_user_product_type(User_id);
        call.enqueue(new Callback<GetUserProducType>() {
            @Override
            public void onResponse(Call<GetUserProducType> call, Response<GetUserProducType> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetUserProducType finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelList= (ArrayList<GetUserProducType.Result>) finallyPr.getResult();

                    setAdapter(modelList);

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(ProductTypeActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetUserProducType> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(ProductTypeActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ADDProductTypeMethod(String productType)
    {
        String User_id = Preference.get(ProductTypeActivity.this,Preference.KEY_USER_ID);

        Call<ProductTypeModel> call = RetrofitClients.getInstance().getApi()
                .add_user_product_type(User_id,productType);
        call.enqueue(new Callback<ProductTypeModel>() {
            @Override
            public void onResponse(Call<ProductTypeModel> call, Response<ProductTypeModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                ProductTypeModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    binding.progressBar.setVisibility(View.GONE);
                    GetAllProductTypeMethod();

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(ProductTypeActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ProductTypeModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(ProductTypeActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AlertDaliogAdd() {

        LayoutInflater li;
        TextView txtSave;
        EditText edtPr;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(ProductTypeActivity.this);
        promptsView = li.inflate(R.layout.alert_product_type_add, null);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(ProductTypeActivity.this);
        alertDialogBuilder.setView(promptsView);

        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String productType=edtPr.getText().toString();

                if(!productType.equalsIgnoreCase(""))
                {
                    if (sessionManager.isNetworkAvailable()) {

                        binding.progressBar.setVisibility(View.VISIBLE);

                        ADDProductTypeMethod(productType);

                    }else {

                        Toast.makeText(ProductTypeActivity.this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
                    }

                }else
                {
                    Toast.makeText(ProductTypeActivity.this, "Please Enter ProductType..", Toast.LENGTH_SHORT).show();
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
}