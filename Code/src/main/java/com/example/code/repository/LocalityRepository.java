package com.example.code.repository;

import com.example.code.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    Optional<Locality> findByPostalCode(String postalCode);
}
