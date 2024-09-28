package com.vaccine.service;

import com.vaccine.DTO.VaccineDTO;
import com.vaccine.model.Vaccine;

import java.util.List;

public interface VaccineService {
    List<Vaccine> getAllVaccines();
    Vaccine saveVaccine(VaccineDTO vaccineDTO);
    Vaccine getVaccineById(Long id); // New method
    List<Vaccine> searchVaccines(String name); // New method
    void deleteVaccine(Long id);
}
