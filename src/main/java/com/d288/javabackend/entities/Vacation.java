package com.d288.javabackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_id")
    private Long id;

    @Column(name="create_date")
    @CreationTimestamp()
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp()
    private Date last_update;

    @Column(name ="description")
    private String description;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "travel_fare_price")
    private Double travel_price;

    @Column(name = "vacation_title")
    private String vacation_title;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
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

    public String getDescription() {
        return description;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public Double getTravel_price() {
        return travel_price;
    }

    public String getVacation_title() {
        return vacation_title;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public void setTravel_price(Double travel_price) {
        this.travel_price = travel_price;
    }

    public void setVacation_title(String vacation_title) {
        this.vacation_title = vacation_title;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

}
