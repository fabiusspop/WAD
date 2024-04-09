package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthService;
import com.wad.firstmvc.repositories.HealthServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceServiceImpl implements HealthServiceService {
    @Autowired
    HealthServiceRepository healthServiceRepository;

    @Override
    public void save(HealthService healthService) {
        healthServiceRepository.save(healthService);
    }

    @Override
    public List<HealthService> findAll() {
        return (List<HealthService>) healthServiceRepository.findAll();
    }
}
