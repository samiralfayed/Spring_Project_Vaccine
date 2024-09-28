package com.vaccine.repository;

import com.vaccine.model.PatientVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientVaccineJPARepo extends JpaRepository<PatientVaccine, Long> {
   List<PatientVaccine> findByPatientIdOrVaccineId(Long patientId, Long vaccineId);
   }
