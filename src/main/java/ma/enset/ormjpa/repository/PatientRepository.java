package ma.enset.ormjpa.repository;

import ma.enset.ormjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Spring data
public interface PatientRepository extends JpaRepository<Patient, Long> {
    //chercher les patients par nom
    List<Patient> findByNomContains(String nom);
    // ou je peux utiliser une requete jpql
    @Query("select p from Patient p where p.nom like :nom")
    //@Param pour montrer que nom represente le parametre nom
    List<Patient> search(@Param("nom") String nom);

    List<Patient> findByScoreGreaterThan(int score);
    //ou bien je peux utiliser une requete jpql
    @Query("select p from Patient p where p.score > :x")
    List<Patient> searchByScore(@Param("x") int score);


}
