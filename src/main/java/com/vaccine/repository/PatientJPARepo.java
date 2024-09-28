package com.vaccine.repository;

import com.vaccine.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientJPARepo extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);
}
