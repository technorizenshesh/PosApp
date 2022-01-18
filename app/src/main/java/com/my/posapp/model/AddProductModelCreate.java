package com.my.posapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.transform.Result;

public class AddProductModelCreate {

    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("status")
    @Expose
    public String status;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
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

}

