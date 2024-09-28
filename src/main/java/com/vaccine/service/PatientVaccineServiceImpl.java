package com.vaccine.service;

import com.vaccine.DTO.PatientVaccineDTO;
import com.vaccine.model.Patient;
import com.vaccine.model.PatientVaccine;
import com.vaccine.model.Vaccine;
import com.vaccine.repository.PatientJPARepo;
import com.vaccine.repository.PatientVaccineJPARepo;
import com.vaccine.repository.VaccineJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientVaccineServiceImpl implements PatientVaccineService {

    @Autowired
    private PatientVaccineJPARepo patientVaccineJPARepo;
    @Autowired
    private PatientJPARepo patientJPARepo;
    @Autowired
    private VaccineJPARepo vaccineJPARepo;

    @Override
    public List<PatientVaccine> getAllPatientVaccines() {
        return patientVaccineJPARepo.findAll();
    }

    @Override
    public PatientVaccine savePatientVaccine(PatientVaccineDTO patientVaccineDTO) {


        Patient patient = patientJPARepo.findById(patientVaccineDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));

        // Fetch the vaccine by ID from the repository
        Vaccine vaccine = vaccineJPARepo.findById(patientVaccineDTO.getVaccineId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid vaccine ID"));

        // Create a new PatientVaccine entity
        PatientVaccine patientVaccine = new PatientVaccine();

        // Set properties from the DTO to the entity
        patientVaccine.setPatient(patient);
        patientVaccine.setVaccine(vaccine);
        patientVaccine.setVaccinationDate(patientVaccineDTO.getVaccinationDate());

        // Save the PatientVaccine entity to the database
        return patientVaccineJPARepo.save(patientVaccine);
    }

    @Override
    public PatientVaccine getPatientVaccineById(Long id) {
        return patientVaccineJPARepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient Vaccine not found"));
    }

    @Override
    public List<PatientVaccine> searchPatientVaccines(Long patientId, Long vaccineId) {

        return patientVaccineJPARepo.findByPatientIdOrVaccineId(patientId, vaccineId);
    }

    @Override
    public void deletePatientVaccine(Long id) {
        patientVaccineJPARepo.deleteById(id);
    }
}
