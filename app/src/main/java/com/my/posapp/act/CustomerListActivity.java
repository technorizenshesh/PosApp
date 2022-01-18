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
import com.my.posapp.adapter.AllCustomerListAdapter;
import com.my.posapp.adapter.AllproductAdapter;
import com.my.posapp.databinding.ActivityCustomerBinding;
import com.my.posapp.databinding.ActivityCustomerListBinding;
import com.my.posapp.model.GetAllProductCreateModel;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListActivity extends AppCompatActivity {

    ActivityCustomerListBinding binding;

    private SessionManager sessionManager;

    private ArrayList<GetCustomerModel.Result> modelList = new ArrayList<>();
    AllCustomerListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_customer_list);

        sessionManager = new SessionManager(CustomerListActivity.this);

        binding.RRback.setOnClickListener(v -> {

            onBackPressed();

        });

        binding.RRAddCustomer.setOnClickListener(v -> {

            startActivity(new Intent(CustomerListActivity.this,AddNewCustomer.class));

        });

        binding.llOne.setOnClickListener(v -> {

            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CustomerListActivity.this, HomeActivity.class));
        });

        binding.llTwo.setOnClickListener(v -> {

            Toast.makeText(this, "Customer Add", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CustomerListActivity.this, HomeActivity.class));

        });


        if (sessionManager.isNetworkAvailable()) {

            binding.progressBar.setVisibility(View.VISIBLE);

            AllCustomerMethod();


        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }
    }

    private void setAdapter(ArrayList<GetCustomerModel.Result> modelList) {

        //this.modelList.add(new PaymentModel("Corn"));
        mAdapter = new AllCustomerListAdapter(CustomerListActivity.this,modelList);
        binding.recyclerallCustomer.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CustomerListActivity.this);
        binding.recyclerallCustomer.setLayoutManager(linearLayoutManager);
        binding.recyclerallCustomer.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AllCustomerListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetCustomerModel.Result model) {

                String CustomerName = model.getCustomerName().toString();
                String Phone= model.getPhone().toString();
                String Address= model.getAddress().toString();
                String Area= model.getArea().toString();
                String SubDisk= model.getSubdistricName().toString();
                Intent intent=new Intent();
               intent.putExtra("CustomerName",CustomerName);
               intent.putExtra("CustomerID",model.getId());
                intent.putExtra("Phone",Phone);
                intent.putExtra("Address",Address);
                intent.putExtra("Area",Area);
                intent.putExtra("SubDisk",SubDisk);
                setResult(102,intent);
                finish();


            }
        });
    }

    private void AllCustomerMethod()
    {
        String User_id = Preference.get(CustomerListActivity.this,Preference.KEY_USER_ID);

        Call<GetCustomerModel> call = RetrofitClients.getInstance().getApi()
                .get_user_customer(User_id);
        call.enqueue(new Callback<GetCustomerModel>() {
            @Override
            public void onResponse(Call<GetCustomerModel> call, Response<GetCustomerModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetCustomerModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelList= (ArrayList<GetCustomerModel.Result>) finallyPr.getResult();

                    setAdapter(modelList);

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(CustomerListActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetCustomerModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(CustomerListActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}