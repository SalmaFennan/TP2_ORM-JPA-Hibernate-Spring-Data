package ma.enset.tp2_orm_jpa_hibernate_springdata.repositories;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findMedecinByNom(String name);
}

