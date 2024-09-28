package com.vaccine.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VaccineDTO {
    private Long id;
    private String name;
    private Long vaccineTypeId;
}
