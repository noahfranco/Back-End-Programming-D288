package com.d288.javabackend.services;

import com.d288.javabackend.dao.CartRepository;
import com.d288.javabackend.dto.Purchase;
import com.d288.javabackend.dto.PurchaseResponse;
import com.d288.javabackend.entities.Cart;
import com.d288.javabackend.entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Set;

import static com.d288.javabackend.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(ordered);

        cartItems.forEach(item -> cart.add(item));

        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
