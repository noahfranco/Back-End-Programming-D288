package com.d288.javabackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="excursions")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id")
    private Long id;

    @Column(name="create_date")
    @CreationTimestamp()
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp()
    private Date last_update;

    @Column(name = "excursion_price")
    private Double excursion_price;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "image_url")
    private String image_URL;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<CartItem> cartItems = new HashSet<>();

    // Getter
    public Long getId() {
        return id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public Double getExcursion_price() {
        return excursion_price;
    }

    public String getExcursion_title() {
        return excursion_title;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setExcursion_price(Double excursion_price) {
        this.excursion_price = excursion_price;
    }

    public void setExcursion_title(String excursion_title) {
        this.excursion_title = excursion_title;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


}
