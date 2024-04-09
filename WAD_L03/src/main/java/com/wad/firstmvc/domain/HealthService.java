package com.wad.firstmvc.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"healthIssue","medicalEncounter"})
public class HealthService {
    @Id
    @GeneratedValue
    private long ID;
    private String description, type;

    public HealthService(String description, String type) {
        this.description = description;
        this.type = type;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private HealthIssue healthIssue;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private MedicalEncounter medicalEncounter;
}
