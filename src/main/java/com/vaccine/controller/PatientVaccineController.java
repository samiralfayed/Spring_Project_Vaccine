package com.vaccine.controller;

import com.vaccine.DTO.VaccineSearchCriteria;
import com.vaccine.model.PatientVaccine;
import com.vaccine.service.PatientVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vaccine")
public class PatientVaccineController {

    @Autowired
    private PatientVaccineService service;

    // Search vaccines by criteria
    @GetMapping("/search")
    public List<PatientVaccine> searchVaccines(@RequestBody VaccineSearchCriteria criteria) {
        return service.searchVaccines(criteria.getVaccineType(), criteria.getSex(), criteria.getAgeFrom(), criteria.getAgeTo());
    }

    // Save a new vaccine
    @PostMapping("/save")
    public PatientVaccine saveVaccine(@RequestBody PatientVaccine patientVaccine) {
        return service.saveVaccine(patientVaccine);
    }

    // Delete vaccine by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVaccine(@PathVariable Long id) {
        service.deleteVaccineById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // Get vaccine by ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientVaccine> getVaccineById(@PathVariable Long id) {
        PatientVaccine vaccine = service.fetchVaccineById(id);
        if (vaccine != null) {
            return ResponseEntity.ok(vaccine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
