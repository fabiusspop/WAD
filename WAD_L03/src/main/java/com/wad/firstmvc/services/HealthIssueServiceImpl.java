package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.repositories.HealthIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthIssueServiceImpl implements HealthIssueService {
    @Autowired
    HealthIssueRepository healthIssueRepository;

    @Override
    public void save(HealthIssue healthIssue) {
        healthIssueRepository.save(healthIssue);
    }

    @Override
    public List<HealthIssue> findAll() {
        return (List<HealthIssue>) healthIssueRepository.findAll();
    }

    @Override
    public List<HealthIssue> findHealthIssuesByPatientName(String patient) {
        return healthIssueRepository.findHealthIssuesByPatientName(patient);
    }
}
