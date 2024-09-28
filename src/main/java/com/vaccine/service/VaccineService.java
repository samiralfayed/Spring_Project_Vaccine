package com.vaccine.service;

import com.vaccine.DTO.VaccineDTO;
import com.vaccine.model.Vaccine;

import java.util.List;

public interface VaccineService {

    List<Vaccine> getAllVaccines();
    Vaccine saveVaccine(VaccineDTO vaccineDTO);
    void deleteVaccine(Long id);
}
