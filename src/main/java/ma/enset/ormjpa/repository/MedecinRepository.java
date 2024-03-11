package ma.enset.ormjpa.repository;

import ma.enset.ormjpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
