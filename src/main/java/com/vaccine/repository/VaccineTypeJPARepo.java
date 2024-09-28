package com.vaccine.repository;

import com.vaccine.model.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineTypeJPARepo extends JpaRepository<VaccineType, Long> {
}
