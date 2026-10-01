package com.example.admin.model;

public class Order {

    private int orderId;
    private String productName;
    private String status;

    public Order(int orderId, String productName, String status) {

        this.orderId = orderId;
        this.productName = productName;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getStatus() {
        return status;
    }
}