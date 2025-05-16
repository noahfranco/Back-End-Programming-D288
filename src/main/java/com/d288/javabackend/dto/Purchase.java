package com.d288.javabackend.dto;

import com.d288.javabackend.entities.CartItem;
import com.d288.javabackend.entities.Cart;
import java.util.Set;

public class Purchase {
    private Cart cart;
    private Set<CartItem> cartItems;

    // Getter
    public Cart getCart() {
        return cart;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    // Setter
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
