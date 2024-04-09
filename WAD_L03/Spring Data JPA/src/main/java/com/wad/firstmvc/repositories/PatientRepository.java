package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.CareProvider;
import com.wad.firstmvc.domain.HealthIssue;
import com.wad.firstmvc.domain.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("patientRepository")
public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Query(value = "select p from Patient p join p.medicalEncounters encs where encs.date = :date")
    List<Patient> findPatientsByAccidentDate(LocalDate date);
    @Query(value = "select p from Patient p join p.medicalEncounters encs join encs.careProvider cp where cp.name = :careProviderName")
    List<Patient> findPatientsByCareProvider(String careProviderName);

}
