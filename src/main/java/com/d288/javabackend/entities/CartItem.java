package com.d288.javabackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @Column(name="create_date")
    @CreationTimestamp()
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp()
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;

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

    public Cart getCart() {
        return cart;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
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

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

}
