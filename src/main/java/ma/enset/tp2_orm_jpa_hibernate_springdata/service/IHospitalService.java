package ma.enset.tp2_orm_jpa_hibernate_springdata.service;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Consultation;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Medecin;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Patient;
import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezvous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
