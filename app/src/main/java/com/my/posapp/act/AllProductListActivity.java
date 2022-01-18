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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.adapter.AllproductAdapter;
import com.my.posapp.adapter.WaitingForPaymentAdapter;
import com.my.posapp.databinding.ActivityAllProductListBinding;
import com.my.posapp.model.AddProductModelCreate;
import com.my.posapp.model.GetAllProductCreateModel;
import com.my.posapp.model.PaymentModel;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductListActivity extends AppCompatActivity {

    ActivityAllProductListBinding binding;
    private ArrayList<GetAllProductCreateModel.Result> modelList = new ArrayList<>();
    AllproductAdapter mAdapter;
    private View promptsView;
    private AlertDialog alertDialog;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_all_product_list);

        sessionManager = new SessionManager(AllProductListActivity.this);

        binding.RRback.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.RRAddProduct.setOnClickListener(v -> {
            startActivity(new Intent(AllProductListActivity.this, AddProductNew.class));
        });


        if (sessionManager.isNetworkAvailable()) {

            binding.progressBar.setVisibility(View.VISIBLE);

            AddProductMethod();

        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }



    }

    private void setAdapter(ArrayList<GetAllProductCreateModel.Result> modelList) {

        //this.modelList.add(new PaymentModel("Corn"));

        mAdapter = new AllproductAdapter(AllProductListActivity.this, this.modelList);
        binding.recyclerall.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllProductListActivity.this);
        binding.recyclerall.setLayoutManager(linearLayoutManager);
        binding.recyclerall.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new AllproductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetAllProductCreateModel.Result model) {

                String Name= model.getName().toString();
                String SellingPrice= model.getSellingPrice().toString();
                Intent intent=new Intent();
                intent.putExtra("Name",Name);
                intent.putExtra("ProductId",model.getId());
                intent.putExtra("SellingPrice",SellingPrice);
                setResult(101,intent);
                finish();

             /*   Preference.save(AllProductListActivity.this,Preference.KEY_Product_add,"1");

                Toast.makeText(AllProductListActivity.this, "Product Add", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AllProductListActivity.this, CreateOrder.class));*/
            }
        });
    }

    private void AddProductMethod()
    {
        String User_id = Preference.get(AllProductListActivity.this,Preference.KEY_USER_ID);

        Call<GetAllProductCreateModel> call = RetrofitClients.getInstance().getApi()
                .get_product(User_id);
        call.enqueue(new Callback<GetAllProductCreateModel>() {
            @Override
            public void onResponse(Call<GetAllProductCreateModel> call, Response<GetAllProductCreateModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                GetAllProductCreateModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {

                    modelList= (ArrayList<GetAllProductCreateModel.Result>) finallyPr.getResult();
                    setAdapter(modelList);

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AllProductListActivity.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<GetAllProductCreateModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AllProductListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}