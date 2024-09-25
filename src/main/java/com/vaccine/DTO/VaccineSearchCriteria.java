package com.vaccine.DTO;

import lombok.Data;

@Data

public class VaccineSearchCriteria {
    private String vaccineType;
    private String sex;
    private int ageFrom;
    private int ageTo;
}
