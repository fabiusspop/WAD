package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.HealthService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("healthServiceRepository")
public interface HealthServiceRepository extends CrudRepository<HealthService, Long> {
}
