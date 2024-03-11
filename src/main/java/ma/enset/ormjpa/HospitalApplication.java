package ma.enset.ormjpa;

import ma.enset.ormjpa.entities.*;
import ma.enset.ormjpa.repository.ConsultationRepository;
import ma.enset.ormjpa.repository.MedecinRepository;
import ma.enset.ormjpa.repository.PatientRepository;
import ma.enset.ormjpa.repository.RendezVousRepository;
import ma.enset.ormjpa.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    // methode qui va executer au demarrage et qui retourne un objet de type CommandLineRunner

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            //patientRepository.save(new Patient(null, "Hassan", new Date(), false, 4, null));
            // pour specifier seulement les parametres qu'on veut
            Stream.of("Oussama", "Doha", "Oumaima").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });
            Stream.of("Fatima", "Wiam", "Amine").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setName(nom);
                medecin.setEmail(nom+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardiologue":"Chirurgien");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient = patientRepository.findById(3L).orElse(null);

            Medecin medecin = medecinRepository.findById(3L).orElse(null);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveRendezVous = hospitalService.saveRendezVous(rendezVous);
            System.out.println(saveRendezVous.getId());

            RendezVous rendezVous1 = rendezVousRepository.findById(3L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rappot de la consultation");
            hospitalService.saveConsultation(consultation);
        };
    }
}