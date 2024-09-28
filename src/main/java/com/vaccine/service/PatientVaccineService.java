package com.vaccine.service;

import com.vaccine.DTO.PatientVaccineDTO;
import com.vaccine.model.PatientVaccine;
import java.util.List;

public interface PatientVaccineService {

    List<PatientVaccine> getAllPatientVaccines();
    PatientVaccine savePatientVaccine(PatientVaccineDTO patientVaccineDTO);
    PatientVaccine getPatientVaccineById(Long id); // New method
    List<PatientVaccine> searchPatientVaccines(Long patientId, Long vaccineId); // New method
    void deletePatientVaccine(Long id);
}
