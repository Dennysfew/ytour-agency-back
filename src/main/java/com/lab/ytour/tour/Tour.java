package com.lab.ytour.tour;

import javax.persistence.*;

@Entity
@Table
public class Tour {
    @Id
    @SequenceGenerator(
            name = "tour_sequence",
            sequenceName = "tour_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "tour_sequence"
    )
    private Long id;
    private String description;
    private String country;
    private Integer price;
    private String image;

    public Tour() {
    }

    public Tour(Long id, String description, String country, Integer price, String image) {
        this.id = id;
        this.description = description;
        this.country = country;
        this.price = price;
        this.image = image;
    }

    public Tour(String description, String country, Integer price, String image) {
        this.description = description;
        this.country = country;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
