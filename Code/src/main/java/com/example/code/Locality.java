package com.example.localitymanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "localities", uniqueConstraints = @UniqueConstraint(columnNames = "postalCode"))
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String postalCode;

    @Column(nullable = false)
    private LocalDate foundingDate;

    @Column(nullable = false)
    private Integer population;

    public Locality() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public LocalDate getFoundingDate() { return foundingDate; }
    public void setFoundingDate(LocalDate foundingDate) { this.foundingDate = foundingDate; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }
}
