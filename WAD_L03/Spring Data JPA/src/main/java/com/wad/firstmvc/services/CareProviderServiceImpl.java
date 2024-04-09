package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.repositories.CareProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareProviderServiceImpl implements CareProviderService {
    @Autowired
    CareProviderRepository careProviderRepository;

    @Override
    public void save(CareProvider careProvider) {
        careProviderRepository.save(careProvider);
    }

    @Override
    public List<CareProvider> findAll() {
        return (List<CareProvider>) careProviderRepository.findAll();
    }

    @Override
    public List<CareProvider> findCareProvidersByHistory(String healthIssue) {
        return careProviderRepository.findCareProvidersByHistory(healthIssue);
    }
}
