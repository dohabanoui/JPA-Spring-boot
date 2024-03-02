package ma.enset.ormjpa;

import ma.enset.ormjpa.entities.Patient;
import ma.enset.ormjpa.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmJpaApplication implements CommandLineRunner {
    //injection de dependance
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(OrmJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hassan", new Date(), false, 4));
        patientRepository.save(new Patient(null, "Khalid", new Date(), true, 5));
        patientRepository.save(new Patient(null, "Omar", new Date(), false, 6));
/*
        //consulter tous les patients
        patientRepository.findAll().forEach(p -> {
            System.out.println(p.toString());
        });

        //consulter un patient
        Patient patient = patientRepository.findById(2L).get();
        System.out.println(patient.toString());

        //mettre a jour un patient
        patient.setNom("imad");
        patientRepository.save(patient);

        //supprimer un patient
        patientRepository.delete(patient);
        */

        //chercher les patients par nom
        List<Patient> Listpatients1 = patientRepository.findByNomContains("n");
        Listpatients1.forEach(p -> {
            System.out.println(p.toString());
        });

        System.out.println("*******************");

        List<Patient> Listpatients2 = patientRepository.search("%n%");
        Listpatients2.forEach(p -> {
            System.out.println(p.toString());
        });

        System.out.println("*******************");

        List<Patient> Listpatients3 = patientRepository.findByScoreGreaterThan(5);
        Listpatients3.forEach(p -> {
            System.out.println(p.toString());
        });

        System.out.println("*******************");

        List<Patient> Listpatients4 = patientRepository.searchByScore(5);
        Listpatients4.forEach(p -> {
            System.out.println(p.toString());
        });



    }
}
