package ma.enset.tp2_orm_jpa_hibernate_springdata.web;

import ma.enset.tp2_orm_jpa_hibernate_springdata.entities.Patient;
import ma.enset.tp2_orm_jpa_hibernate_springdata.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public  List<Patient> patientList(){
        return patientRepository.findAll();
    }

}