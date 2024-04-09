package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.HealthIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("healthIssueRepository")
public interface HealthIssueRepository extends CrudRepository<HealthIssue, Long> {
    // returns all health issues of this patient
    @Query(value = "select hi from HealthIssue hi where hi.patient.name = :patient")
    List<HealthIssue> findHealthIssuesByPatientName(String patient);
}
