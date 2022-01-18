package com.my.posapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCreatePurchesShupplier {

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
        @SerializedName("supplier_id")
        @Expose
        public String supplierId;
        @SerializedName("product_id")
        @Expose
        public String productId;
        @SerializedName("quantity")
        @Expose
        public String quantity;
        @SerializedName("total_quantity")
        @Expose
        public String totalQuantity;
        @SerializedName("subtotal")
        @Expose
        public String subtotal;
        @SerializedName("tax")
        @Expose
        public String tax;
        @SerializedName("discount")
        @Expose
        public String discount;
        @SerializedName("discount_type")
        @Expose
        public String discountType;
        @SerializedName("procurement_cost")
        @Expose
        public String procurementCost;
        @SerializedName("estimated_amount")
        @Expose
        public String estimatedAmount;
        @SerializedName("date_time")
        @Expose
        public String dateTime;
        @SerializedName("status")
        @Expose
        public String status;

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

        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
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

        public String getTotalQuantity() {
            return totalQuantity;
        }

        public void setTotalQuantity(String totalQuantity) {
            this.totalQuantity = totalQuantity;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountType() {
            return discountType;
        }

        public void setDiscountType(String discountType) {
            this.discountType = discountType;
        }

        public String getProcurementCost() {
            return procurementCost;
        }

        public void setProcurementCost(String procurementCost) {
            this.procurementCost = procurementCost;
        }

        public String getEstimatedAmount() {
            return estimatedAmount;
        }

        public void setEstimatedAmount(String estimatedAmount) {
            this.estimatedAmount = estimatedAmount;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
}

