package com.my.posapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCustomerModel {

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
        @SerializedName("area_name")
        @Expose
        public String areaName;
        @SerializedName("subdistric_name")
        @Expose
        public String subdistricName;
        @SerializedName("customer_group_name")
        @Expose
        public String customerGroupName;

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

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getSubdistricName() {
            return subdistricName;
        }

        public void setSubdistricName(String subdistricName) {
            this.subdistricName = subdistricName;
        }

        public String getCustomerGroupName() {
            return customerGroupName;
        }

        public void setCustomerGroupName(String customerGroupName) {
            this.customerGroupName = customerGroupName;
        }

    }
}

