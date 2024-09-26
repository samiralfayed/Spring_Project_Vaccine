package com.vaccine.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VaccineSearchCriteria {


    private String vaccineType;

    @NotNull(message = "Sex cannot be null")
    private String sex;

    private Integer ageFrom;
    private Integer ageTo;


    public VaccineSearchCriteria() {}

    @Override
    public String toString() {
        return "VaccineSearchCriteria{" +
                "vaccineType='" + vaccineType + '\'' +
                ", sex='" + sex + '\'' +
                ", ageFrom=" + ageFrom +
                ", ageTo=" + ageTo +
                '}';
    }
}
