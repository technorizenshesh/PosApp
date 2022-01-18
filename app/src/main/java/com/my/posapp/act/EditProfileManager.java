package com.my.posapp.act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.my.posapp.Oshop.EditProfile;
import com.my.posapp.Preference;
import com.my.posapp.R;
import com.my.posapp.databinding.ActivityEditProfileBinding;
import com.my.posapp.databinding.ActivityEditProfileManagerBinding;
import com.my.posapp.model.LoginModel;
import com.my.posapp.utils.FileUtil;
import com.my.posapp.utils.RetrofitClients;
import com.my.posapp.utils.SessionManager;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileManager extends AppCompatActivity {

    ActivityEditProfileManagerBinding binding;
    private SessionManager sessionManager;

    private Bitmap bitmap;
    private Uri resultUri;
    //private SessionManager sessionManager;
    public static File UserProfile_img, codmpressedImage, compressActualFile;
    boolean isProfileImage=false;

    String Name="";
    String Email="";
    String Mobile="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_edit_profile_manager);

        binding.TxtSave.setOnClickListener(v -> {

             Name = binding.edtName.getText().toString();
             Email = binding.edtEmail.getText().toString();
             Mobile = binding.edtMobile.getText().toString();

            if (sessionManager.isNetworkAvailable()) {

                binding.progressBar.setVisibility(View.VISIBLE);

                ApIUpdateMehod();

            }else {
                Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
            }

        });

        binding.RRUserImg.setOnClickListener(v -> {

            Dexter.withActivity(EditProfileManager.this)
                    .withPermissions(Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                            if (report.areAllPermissionsGranted()) {
                                Intent intent = CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).getIntent(EditProfileManager.this);
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


        sessionManager = new SessionManager(EditProfileManager.this);

        if (sessionManager.isNetworkAvailable()) {

            binding.progressBar.setVisibility(View.VISIBLE);

            getProfileMethod();

        }else {
            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }

    }

    private void showSettingDialogue() {

        AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileManager.this);
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                resultUri = result.getUri();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);

                    UserProfile_img = FileUtil.from(this, resultUri);

                    Glide.with(this).load(bitmap).circleCrop().into(binding.imgeUSer);

                    isProfileImage = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    codmpressedImage = new Compressor(this)
                            .setMaxWidth(640)
                            .setMaxHeight(480)
                            .setQuality(75)
                            .setCompressFormat(Bitmap.CompressFormat.WEBP)
                            .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_PICTURES).getAbsolutePath())
                            .compressToFile(UserProfile_img);
                    Log.e("ActivityTag", "imageFilePAth: " + codmpressedImage);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


    private void getProfileMethod(){

       String Userid= Preference.get(EditProfileManager.this,Preference.KEY_USER_ID);

        Call<LoginModel> call = RetrofitClients.getInstance().getApi()
                .get_profile(Userid);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                LoginModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1")) {

                   // Preference.save(LoginActivity.this,Preference.KEY_USER_ID,finallyPr.result.id);

                     Name=finallyPr.result.firstName.toString();
                    Email=finallyPr.result.email.toString();
                    Mobile=finallyPr.result.mobile.toString();


                    binding.edtName.setText(finallyPr.result.firstName+"");
                    binding.edtEmail.setText(finallyPr.result.email+"");
                    binding.edtMobile.setText(finallyPr.result.mobile+"");


                    if(!finallyPr.result.image.equalsIgnoreCase(""))
                    {
                        Glide.with(EditProfileManager.this).load(finallyPr.result.image).into(binding.imgeUSer);
                    }

                } else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(EditProfileManager.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(EditProfileManager.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ApIUpdateMehod(){

        String Userid= Preference.get(EditProfileManager.this,Preference.KEY_USER_ID);

        MultipartBody.Part imgFile = null;

        if (UserProfile_img == null) {

        } else {
            RequestBody requestFileOne = RequestBody.create(MediaType.parse("image/*"),UserProfile_img);
            imgFile = MultipartBody.Part.createFormData("image",UserProfile_img.getName(), requestFileOne);
        }

        RequestBody UserId = RequestBody.create(MediaType.parse("text/plain"), Userid);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), Name);
        RequestBody email = RequestBody.create(MediaType.parse("text/plain"), Email);
        RequestBody mobile = RequestBody.create(MediaType.parse("text/plain"), Mobile);
        RequestBody lat = RequestBody.create(MediaType.parse("text/plain"), "75.00");
        RequestBody lon = RequestBody.create(MediaType.parse("text/plain"), "75.00");

        Call<LoginModel> call = RetrofitClients
                .getInstance()
                .getApi()
                .update_profile(UserId,name,email,mobile,lat,lon,imgFile);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                binding.progressBar.setVisibility(View.GONE);

                LoginModel finallyPr = response.body();

                String status = finallyPr.status;

                if (status.equalsIgnoreCase("1")) {

                    Name=finallyPr.result.firstName.toString();
                    Email=finallyPr.result.email.toString();
                    Mobile=finallyPr.result.mobile.toString();

                    binding.edtName.setText(finallyPr.result.firstName+"");
                    binding.edtEmail.setText(finallyPr.result.email+"");
                    binding.edtMobile.setText(finallyPr.result.mobile+"");

                    if(!finallyPr.result.image.equalsIgnoreCase(""))
                    {
                        Glide.with(EditProfileManager.this).load(finallyPr.result.image).into(binding.imgeUSer);
                    }


                } else {
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(EditProfileManager.this, finallyPr.message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(EditProfileManager.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}