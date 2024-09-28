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

import java.util.Date;
import java.util.List;

@Service
public class PatientVaccineServiceImpl implements PatientVaccineService {

    @Autowired
    private PatientVaccineJPARepo patientVaccineJPARepo;

    @Autowired
    private PatientJPARepo patientJPARepo;

    @Autowired
    private VaccineJPARepo vaccineJPARepo;


    public List<PatientVaccine> getAllPatientVaccines() {
        return patientVaccineJPARepo.findAll();
    }


    public PatientVaccine savePatientVaccine(PatientVaccineDTO patientVaccineDTO) {
        Patient patient = patientJPARepo.findById(patientVaccineDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Vaccine vaccine = vaccineJPARepo.findById(patientVaccineDTO.getVaccineId())
                .orElseThrow(() -> new RuntimeException("Vaccine not found"));

        PatientVaccine patientVaccine = new PatientVaccine();
        patientVaccine.setPatient(patient);
        patientVaccine.setVaccine(vaccine);
        patientVaccine.setVaccinationDate(patientVaccineDTO.getVaccinationDate() != null ?
                patientVaccineDTO.getVaccinationDate() : new Date());

        return patientVaccineJPARepo.save(patientVaccine);
    }
}
