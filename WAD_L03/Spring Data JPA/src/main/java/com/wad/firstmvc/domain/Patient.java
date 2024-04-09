package com.wad.firstmvc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"medicalEncounters", "healthIssues"})
public class Patient {
    @Id
    @GeneratedValue
    private long ID;
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MedicalEncounter> medicalEncounters = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HealthIssue> healthIssues = new HashSet<>();

    public void addMedicalEncounter(MedicalEncounter medicalEncounter) {
        this.getMedicalEncounters().add(medicalEncounter);
        medicalEncounter.setPatient(this);
    }

    public void addHealthIssue(HealthIssue healthIssue) {
        this.getHealthIssues().add(healthIssue);
        healthIssue.setPatient(this);
    }
}
