package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.AllGetSuppleyerAdapter;
import com.my.posapp.databinding.ActivityPurchesOrderBinding;
import com.my.posapp.model.AllGetPurchesListModel;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PurchesOrderActivity extends AppCompatActivity {

    ActivityPurchesOrderBinding binding;
    private SessionManager sessionManager;

    private ArrayList<AllGetPurchesListModel.Result> modelList = new ArrayList<AllGetPurchesListModel.Result>();
    AllGetSuppleyerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_purches_order);

        sessionManager = new SessionManager(PurchesOrderActivity.this);

        binding.RRBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRAddPurchesOrder.setOnClickListener(v -> {
            startActivity(new Intent(PurchesOrderActivity.this,AddPurchesOrder.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager.isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);
            AllpurchessrMethod();
        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }
    }

    private void setAdapter(ArrayList<AllGetPurchesListModel.Result> modelList) {
     /*   modelList.add(new AllGetPurchesListModel("Corn",""));
        modelList.add(new AllGetPurchesListModel("Corn",""));
*/
        mAdapter = new AllGetSuppleyerAdapter(PurchesOrderActivity.this,modelList);
        binding.recycleGetSupplyer.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PurchesOrderActivity.this);
        binding.recycleGetSupplyer.setLayoutManager(linearLayoutManager);
        binding.recycleGetSupplyer.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AllGetSuppleyerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,AllGetPurchesListModel.Result model) {

                startActivity(new Intent(PurchesOrderActivity.this,CreatePurchesOrderShupplier.class));

            }
        });
    }


    private void AllpurchessrMethod()
    {
        String User_id = Preference.get(PurchesOrderActivity.this,Preference.KEY_USER_ID);

        Call<AllGetPurchesListModel> call = RetrofitClients.getInstance().getApi()
                .get_user_supplier(User_id);
        call.enqueue(new Callback<AllGetPurchesListModel>() {
            @Override
            public void onResponse(Call<AllGetPurchesListModel> call, Response<AllGetPurchesListModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                AllGetPurchesListModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                           modelList= (ArrayList<AllGetPurchesListModel.Result>) finallyPr.getResult();

                           setAdapter(modelList);
                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(PurchesOrderActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AllGetPurchesListModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(PurchesOrderActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}