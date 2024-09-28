package com.vaccine.service;



import com.vaccine.DTO.PatientDTO;
import com.vaccine.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient savePatient(PatientDTO patientDTO);
    void deletePatient(Long id);
    Patient updatePatient(Long id, PatientDTO patientDTO);
}