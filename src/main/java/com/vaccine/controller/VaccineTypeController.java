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

    // Get vaccine type by ID
    @GetMapping("/{id}")
    public ResponseEntity<VaccineType> getVaccineTypeById(@PathVariable Long id) {
        VaccineType vaccineType = vaccineTypeService.getVaccineTypeById(id);
        return new ResponseEntity<>(vaccineType, HttpStatus.OK);
    }

    // Search vaccine types by name
    @GetMapping("/search")
    public ResponseEntity<List<VaccineType>> searchVaccineTypes(@RequestParam("name") String name) {
        List<VaccineType> vaccineTypes = vaccineTypeService.searchVaccineTypes(name);
        return new ResponseEntity<>(vaccineTypes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VaccineType> createVaccineType(@RequestBody VaccineTypeDTO vaccineTypeDTO) {
        VaccineType savedVaccineType = vaccineTypeService.saveVaccineType(vaccineTypeDTO);
        return new ResponseEntity<>(savedVaccineType, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccineType(@PathVariable Long id) {
        vaccineTypeService.deleteVaccineType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
