package com.d288.javabackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name = "package_price")
    private Double package_price;

    @Column(name = "party_size")
    private Integer party_size;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="create_date")
    @CreationTimestamp()
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp()
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    // Getter
    public Long getId() {
        return id;
    }

    public Double getPackage_price() {
        return package_price;
    }

    public Integer getParty_size() {
        return party_size;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setPackage_price(Double package_price) {
        this.package_price = package_price;
    }

    public void setParty_size(Integer party_size) {
        this.party_size = party_size;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
         this.orderTrackingNumber = orderTrackingNumber;
    }

    public void getCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void getLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void add(CartItem cartItem) {
        if (cartItem != null) {
            cartItems.add(cartItem);
            cartItem.setCart(this);
        }
    }
}
