package com.vaccine.service;

import com.vaccine.model.PatientVaccine;
import java.util.List;

public interface PatientVaccineService {

    // Save or update a PatientVaccine
    PatientVaccine saveVaccine(PatientVaccine patientVaccine);

    // Fetch all PatientVaccines
    List<PatientVaccine> fetchVaccineList();

    // Fetch PatientVaccine by ID
    PatientVaccine fetchVaccineById(long id);

    // Delete PatientVaccine by ID
    void deleteVaccineById(long id);

    // Add the search method
    List<PatientVaccine> searchVaccines(String vaccineType, String sex, int ageFrom, int ageTo);
}
