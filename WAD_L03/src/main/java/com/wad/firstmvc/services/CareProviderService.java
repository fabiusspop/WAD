package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import java.util.List;

public interface CareProviderService {
    void save(CareProvider careProvider);
    List<CareProvider> findAll();
    List<CareProvider> findCareProvidersByHistory(String healthIssue);
}
