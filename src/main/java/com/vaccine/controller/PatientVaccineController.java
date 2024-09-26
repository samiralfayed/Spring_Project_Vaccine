package com.vaccine.controller;

import com.vaccine.DTO.VaccineSearchCriteria;
import com.vaccine.model.PatientVaccine;
import com.vaccine.service.PatientVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccines")
public class PatientVaccineController {

    @Autowired
    private PatientVaccineService service;

    // Save a new vaccine
    @PostMapping
    public PatientVaccine saveVaccine(@RequestBody PatientVaccine patientVaccine) {
        return service.saveVaccine(patientVaccine);
    }

    // Fetch all vaccines
    @GetMapping
    public List<PatientVaccine> fetchAllVaccines() {
        return service.fetchVaccineList();
    }

    // Fetch a vaccine by ID
    @GetMapping("/{id}")
    public PatientVaccine fetchVaccineById(@PathVariable("id") Long id) {
        return service.fetchVaccineById(id);
    }

    // Update a vaccine
    @PutMapping("/{id}")
    public PatientVaccine updateVaccine(@PathVariable("id") Long id, @RequestBody PatientVaccine vaccineDetails) {
        PatientVaccine existingVaccine = service.fetchVaccineById(id);

        if (existingVaccine == null) {
            throw new RuntimeException("Vaccine not found with ID: " + id);
        }

        // Update vaccine details
        existingVaccine.setPatientName(vaccineDetails.getPatientName());
        existingVaccine.setSex(vaccineDetails.getSex());
        existingVaccine.setAge(vaccineDetails.getAge());
        existingVaccine.setVaccine(vaccineDetails.getVaccine());
        existingVaccine.setVaccineType(vaccineDetails.getVaccineType());
        existingVaccine.setDateAdministered(vaccineDetails.getDateAdministered());

        // Save and return the updated vaccine
        return service.saveVaccine(existingVaccine);
    }

    // Delete a vaccine
    @DeleteMapping("/{id}")
    public String deleteVaccine(@PathVariable("id") Long id) {
        service.deleteVaccineById(id);
        return "Vaccine with ID " + id + " has been deleted successfully.";
    }

    // Search vaccines by criteria
    @PostMapping("/search")
    public List<PatientVaccine> searchVaccines(@RequestBody VaccineSearchCriteria criteria) {
        return service.searchVaccines(criteria.getVaccineType(), criteria.getSex(), criteria.getAgeFrom(), criteria.getAgeTo());
    }
}
