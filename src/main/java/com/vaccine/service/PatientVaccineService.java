package com.vaccine.service;

import com.vaccine.DTO.PatientVaccineDTO;
import com.vaccine.model.PatientVaccine;
import java.util.List;

public interface PatientVaccineService {

    List<PatientVaccine> getAllPatientVaccines();
    PatientVaccine savePatientVaccine(PatientVaccineDTO patientVaccineDTO);
}
