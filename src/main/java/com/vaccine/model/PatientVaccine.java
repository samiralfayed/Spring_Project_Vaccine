package com.vaccine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PatientVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patientName;
    private String sex;
    private int age;
    private String vaccine;
    private String vaccineType;

    // Using LocalDate for better date handling
    private LocalDate dateAdministered;

    // No-args constructor is necessary for JPA
    public PatientVaccine() { }

    // Constructor with selected fields
    public PatientVaccine(String patientName, String sex, int age, String vaccine, String vaccineType, LocalDate dateAdministered) {
        this.patientName = patientName;
        this.sex = sex;
        this.age = age;
        this.vaccine = vaccine;
        this.vaccineType = vaccineType;
        this.dateAdministered = dateAdministered;
    }
}
