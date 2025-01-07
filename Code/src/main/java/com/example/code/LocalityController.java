package com.example.localitymanager.controller;

import com.example.localitymanager.model.Locality;
import com.example.localitymanager.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localities")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping
    public List<Locality> getAllLocalities() {
        return localityService.getAllLocalities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locality> getLocalityById(@PathVariable Long id) {
        Locality locality = localityService.getLocalityById(id);
        return ResponseEntity.ok(locality);
    }

    @PostMapping
    public ResponseEntity<Locality> createLocality(@RequestBody Locality locality) {
        Locality createdLocality = localityService.createLocality(locality);
        return ResponseEntity.ok(createdLocality);
    }
}
