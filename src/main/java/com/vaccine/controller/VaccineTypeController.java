package com.vaccine.controller;

import com.vaccine.DTO.VaccineTypeDTO;
import com.vaccine.model.VaccineType;
import com.vaccine.service.VaccineTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccine-types")
public class VaccineTypeController {
    @Autowired
    private VaccineTypeServiceImpl vaccineTypeService;

    // Get all vaccine types
    @GetMapping
    public ResponseEntity<List<VaccineType>> getAllVaccineTypes() {
        List<VaccineType> vaccineTypes = vaccineTypeService.getAllVaccineTypes();
        return new ResponseEntity<>(vaccineTypes, HttpStatus.OK);
    }

    // Save a new vaccine type
    @PostMapping
    public ResponseEntity<VaccineType> createVaccineType(@RequestBody VaccineTypeDTO vaccineTypeDTO) {
        VaccineType savedVaccineType = vaccineTypeService.saveVaccineType(vaccineTypeDTO);
        return new ResponseEntity<>(savedVaccineType, HttpStatus.CREATED);
    }

    // Delete a vaccine type by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccineType(@PathVariable Long id) {
        vaccineTypeService.deleteVaccineType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
