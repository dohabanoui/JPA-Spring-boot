package ma.enset.ormjpa.service;

import jakarta.transaction.Transactional;
import ma.enset.ormjpa.entities.Consultation;
import ma.enset.ormjpa.entities.Medecin;
import ma.enset.ormjpa.entities.Patient;
import ma.enset.ormjpa.entities.RendezVous;
import ma.enset.ormjpa.repository.ConsultationRepository;
import ma.enset.ormjpa.repository.MedecinRepository;
import ma.enset.ormjpa.repository.PatientRepository;
import ma.enset.ormjpa.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
