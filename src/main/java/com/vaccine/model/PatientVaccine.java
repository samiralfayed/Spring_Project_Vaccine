package com.vaccine.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class PatientVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String sex;
    private int age;
    private String vaccine;
    private String vaccineType;

    @Temporal(TemporalType.DATE)
    private Date dateAdministered;

    // No-args constructor is necessary for JPA
    public PatientVaccine() { }

    // Constructor with selected fields
    public PatientVaccine(String patientName, String sex, int age, String vaccine, String vaccineType, Date dateAdministered) {
        this.patientName = patientName;
        this.sex = sex;
        this.age = age;
        this.vaccine = vaccine;
        this.vaccineType = vaccineType;
        this.dateAdministered = dateAdministered;
    }
}
