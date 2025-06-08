package ma.enset.tp2_orm_jpa_hibernate_springdata;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.*;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.MedecinRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.PatientRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.RendezVousRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.service.HospitalServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2OrmJpaHibernateSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp2OrmJpaHibernateSpringDataApplication.class, args);
    }
    @Bean
    CommandLineRunner start(HospitalServiceImpl hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository) {
        return args -> {
            // insertion de patient
            Stream.of("Kaoutar","Mohammed","Khadija")
                    .forEach(name -> {

                        Patient patient =new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            // insertion de medecin
            Stream.of("Salma","Imane","Hajar","Anas")
                    .forEach(name -> {

                        Medecin medecin =new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);

                    });

            // recherche de patient
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 =patientRepository.findByNom("Mohammed");

            //recherche de medecin

            Medecin medecin =medecinRepository.findMedecinByNom("Salma");


            // creation de rendezVous

            RendezVous rendezVous =new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);

            rendezVousRepository.save(rendezVous);


            // creationde consultation

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation =new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Le rapport de consultaiton ......");
            hospitalService.saveConsultation(consultation);

        };
    }

}
