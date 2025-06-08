package ma.enset.tp2_orm_jpa_hibernate_springdata.repositories;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}