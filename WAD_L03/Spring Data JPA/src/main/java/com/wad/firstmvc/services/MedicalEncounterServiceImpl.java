package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.MedicalEncounter;
import com.wad.firstmvc.repositories.MedicalEncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalEncounterServiceImpl implements MedicalEncounterService {
    @Autowired
    MedicalEncounterRepository medicalEncounterRepository;

    @Override
    public void save(MedicalEncounter medicalEncounter) {
        medicalEncounterRepository.save(medicalEncounter);
    }

    @Override
    public List<MedicalEncounter> findAll() {
        return (List<MedicalEncounter>) medicalEncounterRepository.findAll();
    }
}
