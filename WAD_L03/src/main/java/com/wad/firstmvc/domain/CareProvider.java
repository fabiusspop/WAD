package com.wad.firstmvc.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "medicalEncounters")
public class CareProvider {
    @Id
    @GeneratedValue
    private long ID;
    private String name, specialty;

    public CareProvider(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @OneToMany(mappedBy = "careProvider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MedicalEncounter> medicalEncounters = new HashSet<>();

    public void addMedicalEncounter(MedicalEncounter medicalEncounter) {
        this.getMedicalEncounters().add(medicalEncounter);
        medicalEncounter.setCareProvider(this);
    }
}
