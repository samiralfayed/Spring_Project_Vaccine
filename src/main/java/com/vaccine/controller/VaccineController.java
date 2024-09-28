package com.vaccine.controller;

import com.vaccine.DTO.VaccineDTO;
import com.vaccine.model.Vaccine;
import com.vaccine.service.VaccineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

    @Autowired
    private VaccineServiceImpl vaccineService;

    // Get all vaccines
    @GetMapping
    public ResponseEntity<List<Vaccine>> getAllVaccines() {
        List<Vaccine> vaccines = vaccineService.getAllVaccines();
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    // Save a new vaccine
    @PostMapping
    public ResponseEntity<Vaccine> createVaccine(@RequestBody VaccineDTO vaccineDTO) {
        Vaccine savedVaccine = vaccineService.saveVaccine(vaccineDTO);
        return new ResponseEntity<>(savedVaccine, HttpStatus.CREATED);
    }

    // Delete a vaccine by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
