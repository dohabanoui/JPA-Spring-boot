package ma.enset.ormjpa.service;

import ma.enset.ormjpa.entities.Consultation;
import ma.enset.ormjpa.entities.Medecin;
import ma.enset.ormjpa.entities.Patient;
import ma.enset.ormjpa.entities.RendezVous;

public interface IHospitalService  {
    public Patient savePatient(Patient patient);
    public Medecin saveMedecin(Medecin medecin);
    public RendezVous saveRendezVous(RendezVous rendezVous);
    public Consultation saveConsultation(Consultation consultation);
}
