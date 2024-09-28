package com.vaccine.service;

import com.vaccine.DTO.VaccineTypeDTO;
import com.vaccine.model.VaccineType;

import java.util.List;

public interface VaccineTypeService {

    List<VaccineType> getAllVaccineTypes();
    VaccineType saveVaccineType(VaccineTypeDTO vaccineTypeDTO);
    void deleteVaccineType(Long id);
}
