package com.vaccine.repository;

import com.vaccine.model.PatientVaccine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientVaccineJPARepo extends JpaRepository<PatientVaccine, Long> {
 //   List<PatientVaccine> findByVaccineVaccineTypeTypeNameAndSexAndAgeBetween(String vaccineType, String sex, int ageStart, int ageEnd);
   }
