package com.vaccine.service;

import com.vaccine.DTO.VaccineTypeDTO; // Make sure to use the correct package
import com.vaccine.model.VaccineType;
import com.vaccine.repository.VaccineTypeJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineTypeServiceImpl {

    @Autowired
    private VaccineTypeJPARepo vaccineTypeJPARepo;

    public List<VaccineType> getAllVaccineTypes() {
        return vaccineTypeJPARepo.findAll();
    }

    public VaccineType saveVaccineType(VaccineTypeDTO vaccineTypeDTO) {
        VaccineType vaccineType = new VaccineType();
        vaccineType.setName(vaccineTypeDTO.getName()); // This should work if getName() exists
        return vaccineTypeJPARepo.save(vaccineType);
    }

    public void deleteVaccineType(Long id) {
        vaccineTypeJPARepo.deleteById(id);
    }
}
