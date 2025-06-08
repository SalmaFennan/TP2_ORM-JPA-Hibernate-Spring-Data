package ma.enset.tp2_orm_jpa_hibernate_springdata.service;


import jakarta.transaction.Transactional;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Consultation;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Medecin;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Patient;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.RendezVous;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.ConsultationRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.MedecinRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.PatientRepository;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezvous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }

}

