package com.example.code.service;

import com.example.code.Locality;
import com.example.code.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    public Locality getLocalityById(Long id) {
        return localityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Locality with ID " + id + " not found"));
    }

    @Transactional
    public Locality createLocality(Locality locality) {
        if (locality.getName() == null || locality.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (locality.getPostalCode() == null || locality.getPostalCode().isEmpty()) {
            throw new IllegalArgumentException("Postal code cannot be null or empty");
        }
        if (locality.getFoundingDate() == null) {
            throw new IllegalArgumentException("Founding date cannot be null");
        }
        if (locality.getPopulation() == null || locality.getPopulation() <= 0) {
            throw new IllegalArgumentException("Population must be a valid positive number");
        }
        if (localityRepository.findByPostalCode(locality.getPostalCode()).isPresent()) {
            throw new IllegalArgumentException("Postal code already exists: " + locality.getPostalCode());
        }
        return localityRepository.save(locality);
    }

}
