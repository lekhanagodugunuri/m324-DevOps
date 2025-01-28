package com.example.code;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

@Entity
@Table(name = "locations", uniqueConstraints = @UniqueConstraint(columnNames = "zip_code"))
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "zip_code")
    @JsonProperty("zip_code")
    private String postalCode;

    @Column(nullable = false, name = "founding_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate foundingDate;


    @Column(nullable = false, name = "population")
    private Integer population;

    public Locality() {}

    public Locality(Long id, String name, String postalCode, LocalDate foundingDate, Integer population) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.foundingDate = foundingDate;
        this.population = population;
    }

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
