package com.vaccine.service;



import com.vaccine.DTO.PatientDTO;
import com.vaccine.model.Patient;
import com.vaccine.repository.PatientJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientJPARepo patientJPARepo;


    public List<Patient> getAllPatients() {

        return patientJPARepo.findAll();
    }

    public Patient savePatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setSex(patientDTO.getSex());
        patient.setAge(patientDTO.getAge());
        return patientJPARepo.save(patient);
    }

    // Method to get patient by ID

    public Optional<Patient> getPatientById(Long id) {
        return patientJPARepo.findById(id);
    }

    @Override
    public void deletePatient(Long id) {

        patientJPARepo.deleteById(id);
    }

    @Override
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = patientJPARepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        existingPatient.setName(patientDTO.getName());
        existingPatient.setSex(patientDTO.getSex());
        existingPatient.setAge(patientDTO.getAge());

        return patientJPARepo.save(existingPatient);
    }

    public List<Patient> searchPatients(String name) {
        return patientJPARepo.findByNameContainingIgnoreCase(name);
    }
}
