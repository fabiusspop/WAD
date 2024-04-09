package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthIssue;

import java.util.List;

public interface HealthIssueService {
    void save(HealthIssue healthIssue);
    List<HealthIssue> findAll();
    List<HealthIssue> findHealthIssuesByPatientName(String patient);
}
