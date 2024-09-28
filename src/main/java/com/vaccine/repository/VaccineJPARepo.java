package com.vaccine.repository;

import com.vaccine.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineJPARepo extends JpaRepository<Vaccine, Long> {
}
