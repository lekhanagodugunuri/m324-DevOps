package com.example.code.controller;

import com.example.code.Locality;
import com.example.code.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
