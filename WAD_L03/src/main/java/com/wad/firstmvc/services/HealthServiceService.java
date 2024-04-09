package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HealthServiceService {
    void save(HealthService healthService);
    List<HealthService> findAll();
}
