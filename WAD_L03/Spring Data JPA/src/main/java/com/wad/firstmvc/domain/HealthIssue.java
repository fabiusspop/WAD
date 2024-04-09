package com.wad.firstmvc.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "patient")
@EqualsAndHashCode(exclude = "healthServices")
public class HealthIssue {
    @Id
    @GeneratedValue
    private long ID;
    private String type;

    public HealthIssue(String type) {
        this.type = type;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Patient patient;

    @OneToMany(mappedBy = "healthIssue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HealthService> healthServices = new HashSet<>();

    public void addHealthService(HealthService healthService) {
        this.getHealthServices().add(healthService);
        healthService.setHealthIssue(this);
    }
}
