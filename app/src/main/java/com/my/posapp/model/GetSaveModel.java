package com.my.posapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSaveModel {

    @SerializedName("result")
    @Expose
    public List<Result> result = null;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("status")
    @Expose
    public String status;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class Result {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("user_id")
        @Expose
        public String userId;
        @SerializedName("customer_id")
        @Expose
        public String customerId;
        @SerializedName("product_id")
        @Expose
        public String productId;
        @SerializedName("quantity")
        @Expose
        public String quantity;
        @SerializedName("sub_total")
        @Expose
        public String subTotal;
        @SerializedName("promotion")
        @Expose
        public String promotion;
        @SerializedName("discount")
        @Expose
        public String discount;
        @SerializedName("price_type")
        @Expose
        public String priceType;
        @SerializedName("order_notes")
        @Expose
        public String orderNotes;
        @SerializedName("status")
        @Expose
        public String status;
        @SerializedName("date_time")
        @Expose
        public String dateTime;
        @SerializedName("time_ago")
        @Expose
        public String timeAgo;
        @SerializedName("product_details")
        @Expose
        public ProductDetails productDetails;
        @SerializedName("customer_details")
        @Expose
        public CustomerDetails customerDetails;
        @SerializedName("user_details")
        @Expose
        public UserDetails userDetails;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(String subTotal) {
            this.subTotal = subTotal;
        }

        public String getPromotion() {
            return promotion;
        }

        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getPriceType() {
            return priceType;
        }

        public void setPriceType(String priceType) {
            this.priceType = priceType;
        }

        public String getOrderNotes() {
            return orderNotes;
        }

        public void setOrderNotes(String orderNotes) {
            this.orderNotes = orderNotes;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getTimeAgo() {
            return timeAgo;
        }

        public void setTimeAgo(String timeAgo) {
            this.timeAgo = timeAgo;
        }

        public ProductDetails getProductDetails() {
            return productDetails;
        }

        public void setProductDetails(ProductDetails productDetails) {
            this.productDetails = productDetails;
        }

        public CustomerDetails getCustomerDetails() {
            return customerDetails;
        }

        public void setCustomerDetails(CustomerDetails customerDetails) {
            this.customerDetails = customerDetails;
        }

        public UserDetails getUserDetails() {
            return userDetails;
        }

        public void setUserDetails(UserDetails userDetails) {
            this.userDetails = userDetails;
        }

        public class CustomerDetails {

            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("user_id")
            @Expose
            public String userId;
            @SerializedName("customer_name")
            @Expose
            public String customerName;
            @SerializedName("customer_email")
            @Expose
            public String customerEmail;
            @SerializedName("phone")
            @Expose
            public String phone;
            @SerializedName("area")
            @Expose
            public String area;
            @SerializedName("subdistric")
            @Expose
            public String subdistric;
            @SerializedName("address")
            @Expose
            public String address;
            @SerializedName("lat")
            @Expose
            public String lat;
            @SerializedName("lon")
            @Expose
            public String lon;
            @SerializedName("customer_group")
            @Expose
            public String customerGroup;
            @SerializedName("tax_id")
            @Expose
            public String taxId;
            @SerializedName("dob")
            @Expose
            public String dob;
            @SerializedName("gender")
            @Expose
            public String gender;
            @SerializedName("apply_incentive")
            @Expose
            public String applyIncentive;
            @SerializedName("discount")
            @Expose
            public String discount;
            @SerializedName("default_price")
            @Expose
            public String defaultPrice;
            @SerializedName("defaul_tax")
            @Expose
            public String defaulTax;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("date_time")
            @Expose
            public String dateTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerEmail() {
                return customerEmail;
            }

            public void setCustomerEmail(String customerEmail) {
                this.customerEmail = customerEmail;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getSubdistric() {
                return subdistric;
            }

            public void setSubdistric(String subdistric) {
                this.subdistric = subdistric;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getCustomerGroup() {
                return customerGroup;
            }

            public void setCustomerGroup(String customerGroup) {
                this.customerGroup = customerGroup;
            }

            public String getTaxId() {
                return taxId;
            }

            public void setTaxId(String taxId) {
                this.taxId = taxId;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getApplyIncentive() {
                return applyIncentive;
            }

            public void setApplyIncentive(String applyIncentive) {
                this.applyIncentive = applyIncentive;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getDefaultPrice() {
                return defaultPrice;
            }

            public void setDefaultPrice(String defaultPrice) {
                this.defaultPrice = defaultPrice;
            }

            public String getDefaulTax() {
                return defaulTax;
            }

            public void setDefaulTax(String defaulTax) {
                this.defaulTax = defaulTax;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

        }

        public class ProductDetails {

            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("user_id")
            @Expose
            public String userId;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("sku")
            @Expose
            public String sku;
            @SerializedName("instock")
            @Expose
            public String instock;
            @SerializedName("selling_price")
            @Expose
            public String sellingPrice;
            @SerializedName("unit_cost")
            @Expose
            public String unitCost;
            @SerializedName("weight")
            @Expose
            public String weight;
            @SerializedName("weight_unit")
            @Expose
            public String weightUnit;
            @SerializedName("barcode")
            @Expose
            public String barcode;
            @SerializedName("wholesale_price")
            @Expose
            public String wholesalePrice;
            @SerializedName("purchase_price")
            @Expose
            public String purchasePrice;
            @SerializedName("tax_applied")
            @Expose
            public String taxApplied;
            @SerializedName("product_type")
            @Expose
            public String productType;
            @SerializedName("product_brand")
            @Expose
            public String productBrand;
            @SerializedName("description")
            @Expose
            public String description;
            @SerializedName("available_for_sale")
            @Expose
            public String availableForSale;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("date_time")
            @Expose
            public String dateTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public String getInstock() {
                return instock;
            }

            public void setInstock(String instock) {
                this.instock = instock;
            }

            public String getSellingPrice() {
                return sellingPrice;
            }

            public void setSellingPrice(String sellingPrice) {
                this.sellingPrice = sellingPrice;
            }

            public String getUnitCost() {
                return unitCost;
            }

            public void setUnitCost(String unitCost) {
                this.unitCost = unitCost;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getWeightUnit() {
                return weightUnit;
            }

            public void setWeightUnit(String weightUnit) {
                this.weightUnit = weightUnit;
            }

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getWholesalePrice() {
                return wholesalePrice;
            }

            public void setWholesalePrice(String wholesalePrice) {
                this.wholesalePrice = wholesalePrice;
            }

            public String getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(String purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public String getTaxApplied() {
                return taxApplied;
            }

            public void setTaxApplied(String taxApplied) {
                this.taxApplied = taxApplied;
            }

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getProductBrand() {
                return productBrand;
            }

            public void setProductBrand(String productBrand) {
                this.productBrand = productBrand;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAvailableForSale() {
                return availableForSale;
            }

            public void setAvailableForSale(String availableForSale) {
                this.availableForSale = availableForSale;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

        }
        public class UserDetails {

            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("first_name")
            @Expose
            public String firstName;
            @SerializedName("mobile")
            @Expose
            public String mobile;
            @SerializedName("password")
            @Expose
            public String password;
            @SerializedName("email")
            @Expose
            public String email;
            @SerializedName("image")
            @Expose
            public String image;
            @SerializedName("register_id")
            @Expose
            public String registerId;
            @SerializedName("social_id")
            @Expose
            public String socialId;
            @SerializedName("address")
            @Expose
            public String address;
            @SerializedName("lat")
            @Expose
            public String lat;
            @SerializedName("lon")
            @Expose
            public String lon;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("type")
            @Expose
            public String type;
            @SerializedName("date_time")
            @Expose
            public String dateTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getRegisterId() {
                return registerId;
            }

            public void setRegisterId(String registerId) {
                this.registerId = registerId;
            }

            public String getSocialId() {
                return socialId;
            }

            public void setSocialId(String socialId) {
                this.socialId = socialId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

        }


    }
}



