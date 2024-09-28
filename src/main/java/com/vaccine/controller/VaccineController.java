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

    // Get vaccine by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable Long id) {
        Vaccine vaccine = vaccineService.getVaccineById(id);
        return new ResponseEntity<>(vaccine, HttpStatus.OK);
    }

    // Search vaccines by name
    @GetMapping("/search")
    public ResponseEntity<List<Vaccine>> searchVaccines(@RequestParam("name") String name) {
        List<Vaccine> vaccines = vaccineService.searchVaccines(name);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vaccine> createVaccine(@RequestBody VaccineDTO vaccineDTO) {
        Vaccine savedVaccine = vaccineService.saveVaccine(vaccineDTO);
        return new ResponseEntity<>(savedVaccine, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
