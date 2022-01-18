package com.my.posapp.act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityAddProductBinding;
import com.my.posapp.model.AddBrandNameModel;
import com.my.posapp.model.AddModel;
import com.my.posapp.utils.RetrofitClients;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProduct extends AppCompatActivity {

    ActivityAddProductBinding binding;
    public String ProductType="";
    public String Brand="";

    String Product="";
    String SKU="";
    String Weight="";
    String Unit="";
    String OpeningStock="";
    String UnitCost="";
    String RetailPrice="";
    String WholesalePrice="";
    String PurchasePrice="";
    String Description="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_product);

        binding.RRback.setOnClickListener(v ->
        {
            onBackPressed();
        });

        binding.RRAddProduct.setOnClickListener(v -> {
            Dexter.withActivity(AddProduct.this)
                    .withPermissions(Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                            if (report.areAllPermissionsGranted()) {
                                Intent intent = CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).getIntent(AddProduct.this);
                                startActivityForResult(intent, 1);
                            } else {
                                showSettingDialogue();
                            }
                        }
                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();

        });

        binding.RRProductType.setOnClickListener(v -> {

            startActivityForResult(new Intent(AddProduct.this,ProductTypeActivity.class),101);

        });

        binding.RRBrand.setOnClickListener(v -> {

            startActivityForResult(new Intent(AddProduct.this,BrandActivity.class),102);

        });

        binding.TxtSave.setOnClickListener(v -> {

            startActivity(new Intent(AddProduct.this,HomeActivity.class));
            Toast.makeText(this, "Add Product SuccessFull..", Toast.LENGTH_SHORT).show();
         /*    Product=binding.edtProduct.getText().toString();
             SKU=binding.edtSKU.getText().toString();
             Weight=binding.edtWeight.getText().toString();
             Unit=binding.edtUnit.getText().toString();
             OpeningStock=binding.edtOpeningStock.getText().toString();
             UnitCost=binding.edtUnitCost.getText().toString();
             RetailPrice=binding.edtRetailPrice.getText().toString();
             WholesalePrice=binding.edtWholesalePrice.getText().toString();
             PurchasePrice=binding.edtPurchasePrice.getText().toString();
             Description=binding.edtDescription.getText().toString();

            if(Product.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(SKU.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(Weight.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(Unit.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(OpeningStock.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(UnitCost.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(RetailPrice.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(WholesalePrice.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(PurchasePrice.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else if(Description.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }else
            {

            }*/

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101)
        {
             ProductType =data.getStringExtra("Type");
            binding.ProductType.setText(ProductType);

        }

        if(requestCode==102)
        {
             Brand =data.getStringExtra("Type");
            binding.Brand.setText(Brand);
        }
    }

    private void showSettingDialogue() {

        AlertDialog.Builder builder = new AlertDialog.Builder(AddProduct.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                openSetting();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.show();

    }

    private void openSetting() {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }


    private void ADDProductMethod()
    {
        String User_id = Preference.get(AddProduct.this,Preference.KEY_USER_ID);

        Call<AddModel> call = RetrofitClients.getInstance().getApi()
                .add_product(User_id,Product,SKU,OpeningStock,RetailPrice,
                        Unit,Weight,UnitCost,
                        "",WholesalePrice,PurchasePrice,
                        "Yes",ProductType,Brand,
                        Description,"Yes",
                        "Description.png");
        call.enqueue(new Callback<AddModel>() {
            @Override
            public void onResponse(Call<AddModel> call, Response<AddModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                AddModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1"))
                {

                 Toast.makeText(AddProduct.this, finallyPr.message, Toast.LENGTH_SHORT).show();

                }else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(AddProduct.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AddModel> call, Throwable t)
            {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(AddProduct.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}