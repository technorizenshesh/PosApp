package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.CityAdapter;
import com.my.posapp.adapter.CustomeberGroupAdapter;
import com.my.posapp.adapter.KiligramAdapter;
import com.my.posapp.adapter.StateAdapter;
import com.my.posapp.databinding.ActivityAddNewCustomerBinding;
import com.my.posapp.model.AddUserCustomerModel;
import com.my.posapp.model.CityModel;
import com.my.posapp.model.GetAllProductCreateModel;
import com.my.posapp.model.GetCustomerGroup;
import com.my.posapp.model.GetStaterModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewCustomer extends AppCompatActivity {

    ActivityAddNewCustomerBinding binding;

    private String code[] ={"Kg","gm"};
    private int flags[]= {R.drawable.locat,R.drawable.locat,R.drawable.locat,R.drawable.locat};

    private ArrayList<GetCustomerGroup.Result> modelList = new ArrayList<>();
    private ArrayList<GetStaterModel.Result> modelListState = new ArrayList<>();
    private ArrayList<CityModel.Result> modelListCity = new ArrayList<>();

    private SessionManager sessionManager;
    String stateId="";
    String CityId="";
    String CustomerGrpId="";

    String CustomerName="";
    String CustomerPhonenumber="";
    String CustomerEmail="";
    String CustomerDetailed="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_customer);

        sessionManager = new SessionManager(AddNewCustomer.this);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRSave.setOnClickListener(v ->
        {
             CustomerName=binding.edtCustomerName.getText().toString();
             CustomerPhonenumber=binding.edtCustomerPhonenumber.getText().toString();
             CustomerEmail=binding.edtCustomerEmail.getText().toString();
             CustomerDetailed=binding.edtCustomerDetailed.getText().toString();

            if(CustomerName.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Customer Name.", Toast.LENGTH_SHORT).show();

            }else if(CustomerPhonenumber.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Customer Phone Number.", Toast.LENGTH_SHORT).show();

            }else if(CustomerEmail.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Customer Email.", Toast.LENGTH_SHORT).show();

            }else if(CustomerDetailed.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Customer Detailed.", Toast.LENGTH_SHORT).show();

            }else
            {

                if (sessionManager.isNetworkAvailable()) {

                    binding.progressBar.setVisibility(View.VISIBLE);

                    AddCustomerMethod();

                }else {
                    Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (sessionManager.isNetworkAvailable()) {

            binding.progressBar.setVisibility(View.VISIBLE);

            GetStateMethod();

        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }


        binding.spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

                stateId = modelListState.get(pos).getId();

                GetCityMethod(stateId);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        binding.spinnerweightUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

                CustomerGrpId = modelListState.get(pos).getId();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        binding.spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

                CityId = modelListState.get(pos).getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

    private void getCustomerDetailsMethod()
    {

        Call<GetCustomerGroup> call = RetrofitClients.getInstance().getApi()
                .get_customer_group();
        call.enqueue(new Callback<GetCustomerGroup>() {
            @Override
            public void onResponse(Call<GetCustomerGroup> call, Response<GetCustomerGroup> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetCustomerGroup finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelList= (ArrayList<GetCustomerGroup.Result>) finallyPr.getResult();

                    CustomeberGroupAdapter customAdapter=new CustomeberGroupAdapter(AddNewCustomer.this,flags,modelList);
                    binding.spinnerweightUnit.setAdapter(customAdapter);


                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddNewCustomer.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetCustomerGroup> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddNewCustomer.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetStateMethod()
    {

        Call<GetStaterModel> call = RetrofitClients.getInstance().getApi()
                .get_states();
        call.enqueue(new Callback<GetStaterModel>() {
            @Override
            public void onResponse(Call<GetStaterModel> call, Response<GetStaterModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetStaterModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelListState = (ArrayList<GetStaterModel.Result>) finallyPr.getResult();

                    StateAdapter customAdapter=new StateAdapter(AddNewCustomer.this,flags,modelListState);
                    binding.spinnerState.setAdapter(customAdapter);

                    getCustomerDetailsMethod();

                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddNewCustomer.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetStaterModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddNewCustomer.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void GetCityMethod(String stateId)
    {
        Call<CityModel> call = RetrofitClients.getInstance().getApi()
                .get_city(stateId);
        call.enqueue(new Callback<CityModel>() {
            @Override
            public void onResponse(Call<CityModel> call, Response<CityModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                CityModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    modelListCity = (ArrayList<CityModel.Result>) finallyPr.getResult();

                    CityAdapter customAdapter=new CityAdapter(AddNewCustomer.this,flags,modelListCity);
                    binding.spinnerCity.setAdapter(customAdapter);

                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddNewCustomer.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<CityModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddNewCustomer.this, "Sub district Not Found.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AddCustomerMethod()
    {
        String User_id = Preference.get(AddNewCustomer.this,Preference.KEY_USER_ID);

        Call<AddUserCustomerModel> call = RetrofitClients.getInstance().getApi()
                .add_user_customer(User_id,CustomerName,CustomerPhonenumber,CustomerEmail,stateId,CityId,CustomerDetailed
                        ,"45.22","9845.25",CustomerGrpId,"11","1991-12-30","Male","None","0","0","0");
        call.enqueue(new Callback<AddUserCustomerModel>() {
            @Override
            public void onResponse(Call<AddUserCustomerModel> call, Response<AddUserCustomerModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                AddUserCustomerModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {
                    Toast.makeText(AddNewCustomer.this, ""+finallyPr.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();

                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddNewCustomer.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddUserCustomerModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddNewCustomer.this, "Sub district Not Found.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}