package com.vaccine.service;

import com.vaccine.DTO.VaccineDTO;
import com.vaccine.model.Vaccine;
import com.vaccine.repository.VaccineJPARepo;
import com.vaccine.repository.VaccineTypeJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaccine.model.VaccineType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl {

    @Autowired
    private VaccineJPARepo vaccineJPARepo;

    @Autowired
    private VaccineTypeJPARepo vaccineTypeJPARepo;


    public List<Vaccine> getAllVaccines() {
        return vaccineJPARepo.findAll();
    }


    public Vaccine saveVaccine(VaccineDTO vaccineDTO) {
        Vaccine vaccine = new Vaccine();
        vaccine.setName(vaccineDTO.getName());

        VaccineType vaccineType = vaccineTypeJPARepo.findById(vaccineDTO.getVaccineTypeId())
                .orElseThrow(() -> new RuntimeException("Vaccine Type not found"));
        vaccine.setVaccineType(vaccineType);

        return vaccineJPARepo.save(vaccine);
    }


    public void deleteVaccine(Long id) {
        vaccineJPARepo.deleteById(id);
    }
}
