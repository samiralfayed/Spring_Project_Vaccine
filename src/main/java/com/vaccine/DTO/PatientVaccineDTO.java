package com.vaccine.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PatientVaccineDTO {

    private Long id;
    private Long patientId;
    private Long vaccineId;
    private Date vaccinationDate;
}
