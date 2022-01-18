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
import com.my.posapp.adapter.AllSaveListAdapter;
import com.my.posapp.databinding.ActivitySaveOrderListBinding;
import com.my.posapp.model.GetBrandNameModel;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.model.GetSaveModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveOrderList extends AppCompatActivity {

    private ArrayList<GetSaveModel.Result> modelList = new ArrayList<>();
    AllSaveListAdapter mAdapter;

    ActivitySaveOrderListBinding binding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_save_order_list);

        sessionManager = new SessionManager(SaveOrderList.this);

        if (sessionManager.isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);
            GetSaveListMethod();
        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }
    }

    private void setAdapter(ArrayList<GetSaveModel.Result> modelList) {
        //this.modelList.add(new PaymentModel("Corn"));
        mAdapter = new AllSaveListAdapter(SaveOrderList.this, this.modelList);
        binding.recycleSave.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SaveOrderList.this);
        binding.recycleSave.setLayoutManager(linearLayoutManager);
        binding.recycleSave.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AllSaveListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetSaveModel.Result model) {

            }
        });
    }

    private void GetSaveListMethod()
    {
        String User_id = Preference.get(SaveOrderList.this,Preference.KEY_USER_ID);

        Call<GetSaveModel> call = RetrofitClients.getInstance().getApi()
                .get_save_order(User_id);
        call.enqueue(new Callback<GetSaveModel>() {
            @Override
            public void onResponse(Call<GetSaveModel> call, Response<GetSaveModel> response)
            {
                binding.progressBar.setVisibility(View.GONE);
                GetSaveModel finallyPr = response.body();
                String status = finallyPr.status;
                if (status.equalsIgnoreCase("1"))
                {
                    modelList= (ArrayList<GetSaveModel.Result>) finallyPr.getResult();
                    setAdapter(modelList);
                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(SaveOrderList.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetSaveModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(SaveOrderList.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}