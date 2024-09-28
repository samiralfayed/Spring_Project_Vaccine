package com.vaccine.repository;

import com.vaccine.model.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineTypeJPARepo extends JpaRepository<VaccineType, Long> {
    List<VaccineType> findByNameContainingIgnoreCase(String name);
}
