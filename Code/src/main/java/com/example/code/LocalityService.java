package com.example.localitymanager.service;

import com.example.localitymanager.model.Locality;
import com.example.localitymanager.repository.LocalityRepository;
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
        if (localityRepository.findByPostalCode(locality.getPostalCode()).isPresent()) {
            throw new IllegalArgumentException("Postal code already exists: " + locality.getPostalCode());
        }
        if (locality.getPopulation() == null || locality.getPopulation() < 0) {
            throw new IllegalArgumentException("Population must be a valid positive number");
        }
        return localityRepository.save(locality);
    }
}
