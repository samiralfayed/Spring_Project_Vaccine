package com.vaccine.repository;

import com.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineJPARepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByNameContainingIgnoreCase(String name);
}
