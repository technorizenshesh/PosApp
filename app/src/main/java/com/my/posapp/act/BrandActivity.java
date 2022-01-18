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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.AlBrandListAdapter;
import com.my.posapp.adapter.AllPRoductTypeListAdapter;
import com.my.posapp.databinding.ActivityBrandBinding;
import com.my.posapp.databinding.ActivityProductTypeBinding;
import com.my.posapp.model.AddBrandNameModel;
import com.my.posapp.model.GetBrandNameModel;
import com.my.posapp.model.GetUserProducType;
import com.my.posapp.model.ProductTypeModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandActivity extends AppCompatActivity {

    ActivityBrandBinding binding;
    private AlBrandListAdapter mAdapter;
    ArrayList<GetBrandNameModel.Result> modelList=new ArrayList<GetBrandNameModel.Result>();

    private SessionManager sessionManager;

    private View promptsView;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_brand);

        sessionManager = new SessionManager(BrandActivity.this);


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


    private void setAdapter(ArrayList<GetBrandNameModel.Result> modelList) {

        //this.modelList.add(new PaymentModel("Corn"));
        mAdapter = new AlBrandListAdapter(BrandActivity.this,modelList);
        binding.recyclerBrand.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BrandActivity.this);
        binding.recyclerBrand.setLayoutManager(linearLayoutManager);
        binding.recyclerBrand.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AlBrandListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetBrandNameModel.Result model) {

                String BrandType= model.getBrandName().toString();
                Intent intent=new Intent(BrandType);
                intent.putExtra("Type",BrandType);
                setResult(102,intent);
                finish();
            }
        });
    }

    private void GetAllProductTypeMethod()
    {
        String User_id = Preference.get(BrandActivity.this,Preference.KEY_USER_ID);

        Call<GetBrandNameModel> call = RetrofitClients.getInstance().getApi()
                .get_user_brand(User_id);
        call.enqueue(new Callback<GetBrandNameModel>() {
            @Override
            public void onResponse(Call<GetBrandNameModel> call, Response<GetBrandNameModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetBrandNameModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelList= (ArrayList<GetBrandNameModel.Result>) finallyPr.getResult();

                    setAdapter(modelList);

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(BrandActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetBrandNameModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(BrandActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ADDProductTypeMethod(String brand_name)
    {
        String User_id = Preference.get(BrandActivity.this,Preference.KEY_USER_ID);

        Call<AddBrandNameModel> call = RetrofitClients.getInstance().getApi()
                .add_user_brand(User_id,brand_name);
        call.enqueue(new Callback<AddBrandNameModel>() {
            @Override
            public void onResponse(Call<AddBrandNameModel> call, Response<AddBrandNameModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                AddBrandNameModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    binding.progressBar.setVisibility(View.GONE);
                    GetAllProductTypeMethod();

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(BrandActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddBrandNameModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(BrandActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AlertDaliogAdd() {

        LayoutInflater li;
        TextView txtSave;
        EditText edtPr;
        TextView txtCancel;
        AlertDialog.Builder alertDialogBuilder;
        li = LayoutInflater.from(BrandActivity.this);
        promptsView = li.inflate(R.layout.alert_brand_add, null);
        txtSave = (TextView) promptsView.findViewById(R.id.txtSave);
        edtPr = (EditText) promptsView.findViewById(R.id.edtPr);
        txtCancel = (TextView) promptsView.findViewById(R.id.txtCancel);
        alertDialogBuilder = new AlertDialog.Builder(BrandActivity.this);
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

                        Toast.makeText(BrandActivity.this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
                    }

                }else
                {
                    Toast.makeText(BrandActivity.this, "Please Enter ProductType..", Toast.LENGTH_SHORT).show();
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