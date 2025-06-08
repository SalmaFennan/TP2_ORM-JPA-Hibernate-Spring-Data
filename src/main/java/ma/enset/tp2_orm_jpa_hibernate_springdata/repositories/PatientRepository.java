package ma.enset.tp2_orm_jpa_hibernate_springdata.repositories;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findBynomIn(Collection<String> noms);
    Patient findByNom(String names);
}

