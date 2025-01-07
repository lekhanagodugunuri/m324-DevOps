package com.example.code;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    Optional<Locality> findByPostalCode(String postalCode);
}
