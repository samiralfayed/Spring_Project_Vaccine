package com.vaccine.service;

import com.vaccine.model.PatientVaccine;
import com.vaccine.repository.PatientVaccineJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientVaccineServiceJPAImpl implements PatientVaccineService {

    @Autowired
    private PatientVaccineJPARepo patientVaccineRepository;

    // Save or update a PatientVaccine
    @Override
    public PatientVaccine saveVaccine(PatientVaccine vaccine) {
        return patientVaccineRepository.save(vaccine);
    }

    // Fetch all PatientVaccines
    @Override
    public List<PatientVaccine> fetchVaccineList() {
        return patientVaccineRepository.findAll();
    }

    // Fetch PatientVaccine by ID
    @Override
    public PatientVaccine fetchVaccineById(long id) {
        Optional<PatientVaccine> vaccine = patientVaccineRepository.findById(id);
        return vaccine.orElse(null);
    }

    // Delete PatientVaccine by ID
    @Override
    public void deleteVaccineById(long id) {
        patientVaccineRepository.deleteById(id);
    }

    // Search vaccines by vaccineType, sex, and age range
    @Override
    public List<PatientVaccine> searchVaccines(String vaccineType, String sex, int ageFrom, int ageTo) {
        return patientVaccineRepository.findByVaccineTypeAndSexAndAgeBetween(vaccineType, sex, ageFrom, ageTo);
    }
}
