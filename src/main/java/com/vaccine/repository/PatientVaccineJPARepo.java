package com.vaccine.repository;

import com.vaccine.model.PatientVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientVaccineJPARepo extends JpaRepository<PatientVaccine, Long> {
    List<PatientVaccine> findByVaccineTypeAndSexAndAgeBetween(String vaccineType, String sex, int ageFrom, int ageTo);

}
