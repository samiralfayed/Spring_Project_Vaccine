package com.vaccine.controller;

import com.vaccine.DTO.PatientVaccineDTO;
import com.vaccine.model.PatientVaccine;
import com.vaccine.service.PatientVaccineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-vaccines")
public class PatientVaccineController {

    @Autowired
    private PatientVaccineServiceImpl patientVaccineService;

    // Get all patient vaccines
    @GetMapping
    public ResponseEntity<List<PatientVaccine>> getAllPatientVaccines() {
        List<PatientVaccine> patientVaccines = patientVaccineService.getAllPatientVaccines();
        return new ResponseEntity<>(patientVaccines, HttpStatus.OK);
    }

    // Get patient vaccine by ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientVaccine> getPatientVaccineById(@PathVariable Long id) {
        PatientVaccine patientVaccine = patientVaccineService.getPatientVaccineById(id);
        return new ResponseEntity<>(patientVaccine, HttpStatus.OK);
    }

    // Search patient vaccines by patient ID or vaccine ID
    @GetMapping("/search")
    public ResponseEntity<List<PatientVaccine>> searchPatientVaccines(@RequestParam(required = false) Long patientId,
                                                                      @RequestParam(required = false) Long vaccineId) {
        List<PatientVaccine> patientVaccines = patientVaccineService.searchPatientVaccines(patientId, vaccineId);
        return new ResponseEntity<>(patientVaccines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientVaccine> createPatientVaccine(@RequestBody PatientVaccineDTO patientVaccineDTO) {
        PatientVaccine savedPatientVaccine = patientVaccineService.savePatientVaccine(patientVaccineDTO);
        return new ResponseEntity<>(savedPatientVaccine, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientVaccine(@PathVariable Long id) {
        patientVaccineService.deletePatientVaccine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
