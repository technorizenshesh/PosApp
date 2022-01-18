package com.my.posapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveModel {

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

    }

}