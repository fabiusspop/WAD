package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("careProviderRepository")
public interface CareProviderRepository extends CrudRepository<CareProvider, Long> {
    @Query(value = "select cp from CareProvider cp " +
            "join cp.medicalEncounters encs " +
            "join encs.healthServices hs " +
            "where hs.healthIssue.type = :healthIssue")
    List<CareProvider> findCareProvidersByHistory(String healthIssue);
}
