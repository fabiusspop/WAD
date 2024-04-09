package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.MedicalEncounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("medicalEncounterRepository")
public interface MedicalEncounterRepository extends CrudRepository<MedicalEncounter, Long> {
}
