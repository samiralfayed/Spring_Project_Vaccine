package com.vaccine.service;

import com.vaccine.DTO.VaccineTypeDTO;
import com.vaccine.model.VaccineType;

import java.util.List;

public interface VaccineTypeService {
    List<VaccineType> getAllVaccineTypes();
    VaccineType saveVaccineType(VaccineTypeDTO vaccineTypeDTO);
    VaccineType getVaccineTypeById(Long id); // New method
    List<VaccineType> searchVaccineTypes(String name); // New method
    void deleteVaccineType(Long id);
}
