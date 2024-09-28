package com.vaccine.service;

import com.vaccine.DTO.VaccineDTO;
import com.vaccine.model.Vaccine;
import com.vaccine.repository.VaccineJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl {

    @Autowired
    private VaccineJPARepo vaccineJPARepo;


    public List<Vaccine> getAllVaccines() {
        return vaccineJPARepo.findAll();
    }


    public Vaccine saveVaccine(VaccineDTO vaccineDTO) {
        // Create a new Vaccine entity
        Vaccine vaccine = new Vaccine();

        // Set properties from the DTO to the entity
        vaccine.setName(vaccineDTO.getName());
        return vaccineJPARepo.save(vaccine);

    }


    public Vaccine getVaccineById(Long id) {
        return vaccineJPARepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaccine not found"));
    }


    public List<Vaccine> searchVaccines(String name) {
        return vaccineJPARepo.findByNameContainingIgnoreCase(name);
    }


    public void deleteVaccine(Long id) {
        vaccineJPARepo.deleteById(id);
    }
}
