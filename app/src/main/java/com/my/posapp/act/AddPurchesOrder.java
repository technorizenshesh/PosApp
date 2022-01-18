package com.my.posapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.my.posapp.GPSTracker;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.CityAdapter;
import com.my.posapp.adapter.StateAdapter;
import com.my.posapp.databinding.ActivityAddPurchesOrderBinding;
import com.my.posapp.model.AddUserCustomerModel;
import com.my.posapp.model.CityModel;
import com.my.posapp.model.GetStaterModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPurchesOrder extends AppCompatActivity {

    ActivityAddPurchesOrderBinding binding;
    private ArrayList<GetStaterModel.Result> modelListState = new ArrayList<>();
    private ArrayList<CityModel.Result> modelListCity = new ArrayList<>();

    private String code[] ={"Kg","gm"};
    private int flags[]= {R.drawable.locat,R.drawable.locat,R.drawable.locat,R.drawable.locat};


    private SessionManager sessionManager;
    String stateId="";
    String CityId="";

    String SupplyerName ="";
    String SupplyPhonenumber ="";
    String SupplyEmail ="";
    String Address ="";

    GPSTracker gpsTracker;
    String latitude="";
    String longitude="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_purches_order);

        sessionManager = new SessionManager(AddPurchesOrder.this);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRSave.setOnClickListener(v -> {

             SupplyerName = binding.edtSupplyName.getText().toString();
             SupplyPhonenumber = binding.edtSupplyPhonenumber.getText().toString();
             SupplyEmail = binding.edtSupplyEmail.getText().toString();
             Address = binding.edtAddress.getText().toString();

            if(SupplyerName.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Supplyer Name", Toast.LENGTH_SHORT).show();

            }else if(SupplyPhonenumber.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Supplyer Phone number", Toast.LENGTH_SHORT).show();

            }else if(SupplyEmail.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Supplyer email.", Toast.LENGTH_SHORT).show();

            }else if(Address.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please Enter Supplyer adress.", Toast.LENGTH_SHORT).show();

            }else
            {
                if (sessionManager.isNetworkAvailable()) {

                    binding.progressBar.setVisibility(View.VISIBLE);

                    AddSupplyOrderMethod();

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

        binding.spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

                CityId = modelListState.get(pos).getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        //Gps Lat Long
        gpsTracker = new GPSTracker(AddPurchesOrder.this);
        if (gpsTracker.canGetLocation()) {

            latitude = String.valueOf(gpsTracker.getLatitude());
            longitude = String.valueOf(gpsTracker.getLongitude());

        } else {
            gpsTracker.showSettingsAlert();
        }
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

                    StateAdapter customAdapter=new StateAdapter(AddPurchesOrder.this,flags,modelListState);
                    binding.spinnerState.setAdapter(customAdapter);

                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddPurchesOrder.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetStaterModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddPurchesOrder.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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

                    CityAdapter customAdapter=new CityAdapter(AddPurchesOrder.this,flags,modelListCity);
                    binding.spinnerCity.setAdapter(customAdapter);

                }else {

                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddPurchesOrder.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<CityModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddPurchesOrder.this, "Sub district Not Found.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AddSupplyOrderMethod()
    {
        String User_id = Preference.get(AddPurchesOrder.this,Preference.KEY_USER_ID);

        Call<ResponseBody> call = RetrofitClients.getInstance().getApi()
                .add_user_supplier(User_id,SupplyerName,SupplyPhonenumber,SupplyEmail,stateId,Address,latitude,longitude,"200");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                binding.progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(String.valueOf(response.body()));
                    String status = jsonObject.getString("status");
                    String message = jsonObject.getString("message");

                    if(status.equalsIgnoreCase("1"))
                    {
                        Toast.makeText(AddPurchesOrder.this, ""+ message, Toast.LENGTH_SHORT).show();
                        finish();
                    }else
                    {
                        Toast.makeText(AddPurchesOrder.this, ""+message, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(AddPurchesOrder.this, "Success", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
            }
        });

    }



}