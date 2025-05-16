package com.d288.javabackend.services;

import com.d288.javabackend.dto.Purchase;
import com.d288.javabackend.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
