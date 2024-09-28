package com.vaccine.service;

import com.vaccine.DTO.VaccineTypeDTO;
import com.vaccine.model.VaccineType;
import com.vaccine.repository.VaccineTypeJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineTypeServiceImpl implements VaccineTypeService {

    @Autowired
    private VaccineTypeJPARepo vaccineTypeJPARepo;

    @Override
    public List<VaccineType> getAllVaccineTypes() {
        return vaccineTypeJPARepo.findAll();
    }

    @Override
    public VaccineType saveVaccineType(VaccineTypeDTO vaccineTypeDTO) {
        VaccineType vaccineType = new VaccineType();
        vaccineType.setName(vaccineTypeDTO.getName());
        // Set other fields from the DTO as necessary

        return vaccineTypeJPARepo.save(vaccineType);
    }

    @Override
    public VaccineType getVaccineTypeById(Long id) {
        return vaccineTypeJPARepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaccine Type not found"));
    }

    @Override
    public List<VaccineType> searchVaccineTypes(String name) {
        return vaccineTypeJPARepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteVaccineType(Long id) {
        vaccineTypeJPARepo.deleteById(id);
    }
}
