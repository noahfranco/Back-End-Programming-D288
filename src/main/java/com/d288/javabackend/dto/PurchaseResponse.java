package com.d288.javabackend.dto;

public class PurchaseResponse {
    private String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    // Getter
    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    // Setter
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

}
