package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.MedicalEncounter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MedicalEncounterService {
    void save(MedicalEncounter medicalEncounter);
    List<MedicalEncounter> findAll();
}
