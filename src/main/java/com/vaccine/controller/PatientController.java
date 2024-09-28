package com.vaccine.controller;

import com.vaccine.DTO.PatientDTO;
import com.vaccine.model.Patient;
import com.vaccine.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    // Get all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Save a new patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        Patient savedPatient = patientService.savePatient(patientDTO);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Delete a patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Search for patients by name
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam("name") String name) {
        List<Patient> patients = patientService.searchPatients(name);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
