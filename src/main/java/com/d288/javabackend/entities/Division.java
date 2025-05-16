package com.d288.javabackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;

    @Column(name="create_date")
    @CreationTimestamp()
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp()
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private Long country_id;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    // Getter
    public Long getId() {
        return id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public Country getCountry() {
        return country;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setCountry_id(Long id) {
        this.id = id;
    }

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
