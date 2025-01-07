package com.example.localitymanager.repository;

import com.example.localitymanager.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    Optional<Locality> findByPostalCode(String postalCode);
}
