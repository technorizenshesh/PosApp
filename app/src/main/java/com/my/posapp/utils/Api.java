package com.my.posapp.utils;



import com.my.posapp.model.AddBrandNameModel;
import com.my.posapp.model.AddModel;
import com.my.posapp.model.AddProductModelCreate;
import com.my.posapp.model.AddUserCustomerModel;
import com.my.posapp.model.AllGetPurchesListModel;
import com.my.posapp.model.CityModel;
import com.my.posapp.model.GetAllProductCreateModel;
import com.my.posapp.model.GetBrandNameModel;
import com.my.posapp.model.GetCreatePurchesShupplier;
import com.my.posapp.model.GetCustomerGroup;
import com.my.posapp.model.GetCustomerModel;
import com.my.posapp.model.GetSaveModel;
import com.my.posapp.model.GetStaterModel;
import com.my.posapp.model.GetUserProducType;
import com.my.posapp.model.LoginModel;
import com.my.posapp.model.ProductTypeModel;
import com.my.posapp.model.SaveModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    //Oops Manager
    String login ="login";
    String user_signup ="signup";
    String social_login ="social_login";
    String get_profile ="get_profile";
    String update_profile ="update_profile";
    String add_quick_product ="add_quick_product";
    String get_product ="get_product";
    String get_customer_group ="get_customer_group";
    String get_states ="get_states";
    String get_city ="get_city";
    String add_user_customer ="add_user_customer";
    String get_user_customer ="get_user_customer";
    String get_user_product_type ="get_user_product_type";
    String add_user_product_type ="add_user_product_type";
    String get_user_brand ="get_user_brand";
    String add_user_brand ="add_user_brand";
    String add_product ="add_product";
    String save_order ="save_order";
    String get_save_order ="get_save_order";
    String add_user_supplier ="add_user_supplier";
    String get_user_supplier ="get_user_supplier";
    String add_purchase_order ="add_purchase_order";


    @Multipart
    @POST(user_signup)
    Call<LoginModel>user_signup(
            @Part("first_name") RequestBody first_name,
            @Part("email") RequestBody email,
            @Part("mobile") RequestBody mobile,
            @Part("password") RequestBody password,
            @Part("register_id") RequestBody register_id,
            @Part("lat") RequestBody lat,
            @Part("lon") RequestBody lon,
            @Part("type") RequestBody type,
            @Part MultipartBody.Part part1
    );


    @FormUrlEncoded
    @POST(login)
    Call<LoginModel> login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("lat") String lat,
            @Field("lon") String lon,
            @Field("register_id") String register_id
    );


    @FormUrlEncoded
    @POST(social_login)
    Call<LoginModel>social_login(
            @Field("first_name") String first_name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("register_id") String register_id,
            @Field("lat") String lat,
            @Field("lon") String lon,
            @Field("type") String type,
            @Field("social_id") String social_id,
            @Field("image") String image
    );

    @FormUrlEncoded
    @POST(get_profile)
    Call<LoginModel> get_profile(
            @Field("user_id") String user_id
    );

    @Multipart
    @POST(update_profile)
    Call<LoginModel>update_profile(
            @Part("user_id") RequestBody user_id    ,
            @Part("first_name") RequestBody first_name,
            @Part("email") RequestBody email,
            @Part("mobile") RequestBody mobile,
            @Part("lat") RequestBody lat,
            @Part("lon") RequestBody lon,
            @Part MultipartBody.Part part1
    );

    @FormUrlEncoded
    @POST(add_quick_product)
    Call<AddProductModelCreate> add_quick_product(
            @Field("user_id") String user_id,
            @Field("name") String name,
            @Field("sku") String sku,
            @Field("instock") String instock,
            @Field("selling_price") String selling_price,
            @Field("unit_cost") String unit_cost,
            @Field("weight") String weight,
            @Field("weight_unit") String weight_unit
    );

    @FormUrlEncoded
    @POST(get_product)
    Call<GetAllProductCreateModel> get_product(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST(get_user_customer)
    Call<GetCustomerModel> get_user_customer(
            @Field("user_id") String user_id
    );

  @FormUrlEncoded
    @POST(get_user_supplier)
    Call<AllGetPurchesListModel> get_user_supplier(
            @Field("user_id") String user_id
    );


    @POST(get_customer_group)
    Call<GetCustomerGroup> get_customer_group();

 @POST(get_states)
    Call<GetStaterModel> get_states();

    @FormUrlEncoded
    @POST(get_city)
    Call<CityModel> get_city(
            @Field("state_id") String state_id
    );


    @FormUrlEncoded
    @POST(add_user_customer)
    Call<AddUserCustomerModel> add_user_customer(
            @Field("user_id") String user_id,
            @Field("customer_name") String customer_name,
            @Field("phone") String phone,
            @Field("customer_email") String customer_email,
            @Field("area") String area,
            @Field("subdistric") String subdistric,
            @Field("address") String address,
            @Field("lat") String lat,
            @Field("lon") String lon,
            @Field("customer_group") String customer_group,
            @Field("tax_id") String tax_id,
            @Field("dob") String dob,
            @Field("gender") String gender,
            @Field("apply_incentive") String apply_incentive,
            @Field("discount") String discount,
            @Field("default_price") String default_price,
            @Field("defaul_tax") String defaul_tax
    );

    @FormUrlEncoded
    @POST(get_user_product_type)
    Call<GetUserProducType> get_user_product_type(
            @Field("user_id") String user_id
    );


    @FormUrlEncoded
    @POST(add_user_product_type)
    Call<ProductTypeModel> add_user_product_type(
            @Field("user_id") String user_id,
            @Field("product_type") String product_type
    );

    @FormUrlEncoded
    @POST(add_user_supplier)
    Call<ResponseBody> add_user_supplier(
            @Field("user_id") String user_id,
            @Field("supplier_name") String supplier_name,
            @Field("phone_number") String phone_number,
            @Field("email") String email,
            @Field("area") String area,
            @Field("address") String address,
            @Field("lat") String lat,
            @Field("lon") String lon,
            @Field("default_policy") String default_policy
    );

    @FormUrlEncoded
    @POST(get_user_brand)
    Call<GetBrandNameModel> get_user_brand(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST(add_user_brand)
    Call<AddBrandNameModel> add_user_brand(
            @Field("user_id") String user_id,
            @Field("brand_name") String brand_name
    );

    @FormUrlEncoded
    @POST(save_order)
    Call<SaveModel> save_order(
            @Field("user_id") String user_id,
            @Field("customer_id") String customer_id,
            @Field("product_id") String product_id,
            @Field("quantity") String quantity,
            @Field("sub_total") String sub_total,
            @Field("promotion") String promotion,
            @Field("discount") String discount,
            @Field("price_type") String price_type,
            @Field("order_notes") String order_notes
    );

    @FormUrlEncoded
    @POST(add_purchase_order)
    Call<GetCreatePurchesShupplier> add_purchase_order(
            @Field("user_id") String user_id,
            @Field("supplier_id") String supplier_id,
            @Field("customer_id") String customer_id,
            @Field("product_id") String product_id,
            @Field("quantity") String quantity,
            @Field("total_quantity") String total_quantity,
            @Field("subtotal") String subtotal,
            @Field("tax") String tax,
            @Field("discount") String discount,
            @Field("discount_type") String discount_type,
            @Field("procurement_cost") String procurement_cost,
            @Field("estimated_amount") String estimated_amount
    );

    @FormUrlEncoded
    @POST(add_product)
    Call<AddModel> add_product(
            @Field("user_id") String user_id,
            @Field("name") String name,
            @Field("sku") String sku,
            @Field("instock") String instock,
            @Field("selling_price") String selling_price,
            @Field("unit_cost") String unit_cost,
            @Field("weight") String weight,
            @Field("weight_unit") String weight_unit,
            @Field("barcode") String barcode,
            @Field("wholesale_price") String wholesale_price,
            @Field("purchase_price") String purchase_price,
            @Field("tax_applied") String tax_applied,
            @Field("product_type") String product_type,
            @Field("product_brand") String product_brand,
            @Field("description") String description,
            @Field("available_for_sale") String available_for_sale,
            @Field("image[]") String image
    );


    @FormUrlEncoded
    @POST(get_save_order)
    Call<GetSaveModel> get_save_order(
            @Field("user_id") String user_id
    );

}
