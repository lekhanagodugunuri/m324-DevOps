package com.example.code.service;

import com.example.code.Property;
import com.example.code.Locality;
import com.example.code.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
    // Create a new property
    public Property createProperty(Property property) {
        Locality locality = restTemplate.getForObject("http://localhost:8081/api/localities/" + property.getLocality().getId(), Locality.class);

        if (locality == null) {
            throw new IllegalArgumentException("Invalid locality. The locality does not exist.");
        }

        property.setLocality(locality);
        return propertyRepository.save(property);
    }
}
