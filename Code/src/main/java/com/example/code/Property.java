package com.example.code;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String propertyType;  // Type of the property (e.g., House, Apartment)

    @Column(nullable = false)
    private Double rooms;  // Number of rooms

    @Column(nullable = false)
    private Double area;  // Area in square meters

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Locality locality;  // Reference to the locality (foreign key)

    @Column(nullable = false)
    private Double price;  // Price of the property

    @Column
    private String saleDate;  // Date when the property was sold (optional)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getRooms() {
        return rooms;
    }

    public void setRooms(Double rooms) {
        this.rooms = rooms;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }
}
