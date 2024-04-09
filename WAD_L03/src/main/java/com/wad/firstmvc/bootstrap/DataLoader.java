package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.*;
import com.wad.firstmvc.repositories.PatientRepository;
import com.wad.firstmvc.services.*;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CareProviderService careProviderService;
    @Autowired
    HealthIssueService healthIssueService;
    @Autowired
    HealthServiceService healthServiceService;
    @Autowired
    MedicalEncounterService medicalEncounterService;
    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        Patient alex = new Patient("Alex");

        HealthIssue asthma = new HealthIssue("asthma");

        HealthService bagdasar = new HealthService("inhaler", "general hospital");
        HealthService bucuresti_pulmonology = new HealthService("pulmonology consultation", "pulmonology hospital");

        CareProvider drBrown = new CareProvider("dr Brown", "pulmonologist");
        CareProvider drCurie = new CareProvider("dr. Curie", "internal medicine");

        MedicalEncounter Encounter5 = new MedicalEncounter(alex, LocalDate.parse("2020-06-20"));
        MedicalEncounter Encounter6 = new MedicalEncounter(alex, LocalDate.parse("2018-08-15"));

        drBrown.addMedicalEncounter(Encounter5);
        Encounter5.addHealthService(bagdasar);

        drCurie.addMedicalEncounter(Encounter6);
        Encounter6.addHealthService(bucuresti_pulmonology);

        alex.addMedicalEncounter(Encounter5);
        alex.addMedicalEncounter(Encounter6);

        asthma.addHealthService(bagdasar);
        asthma.addHealthService(bucuresti_pulmonology);

        alex.addHealthIssue(asthma);

        careProviderService.save(drBrown);
        careProviderService.save(drCurie);
        patientService.save(alex);
        medicalEncounterService.save(Encounter5);
        medicalEncounterService.save(Encounter6);
        healthIssueService.save(asthma);
        healthServiceService.save(bagdasar);
        healthServiceService.save(bucuresti_pulmonology);

        System.out.println("\n");

        System.out.println("All Patients");
        List<Patient> patients = patientService.findAll();
        patients.forEach(System.out::println);

        System.out.println("\n");

        System.out.println("all health issues");
        List<HealthIssue> healthIssuesByPatient = healthIssueService.findHealthIssuesByPatientName("Alex");
        healthIssuesByPatient.forEach(System.out::println);

        System.out.println(" ");

        System.out.println("Patients who had an accident on \"2020-06-20\"");
        List<Patient> patientsByDate = patientService.findPatientsByAccidentDate(LocalDate.parse("2020-06-20"));
        patientsByDate.forEach(System.out::println);

        System.out.println(" ");

        System.out.println("Patients who had Curie as care provider");
        List<Patient> patientsMetCurie = patientService.findPatientsByCareProvider("dr. Curie");
        patientsMetCurie.forEach(System.out::println);

        System.out.println(" ");

        System.out.println("Care providers who had patients with asthma");
        List<CareProvider> careProvidersByHealthIssue = careProviderService.findCareProvidersByHistory("asthma");
        careProvidersByHealthIssue.forEach(System.out::println);

        System.out.println("\n");


    }
}
