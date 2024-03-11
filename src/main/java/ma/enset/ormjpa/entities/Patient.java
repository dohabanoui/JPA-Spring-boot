package ma.enset.ormjpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
//On utilise les annotations de JPA pour définir les entités


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    // une entity doit avoir un id
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    //j'ai pas besoin de garder l"heure et les minutes
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
    //un patient peut avoir plusieurs rendez-vous
    // dans mappedBy on met le nom de l'attribut dans la classe RendezVous
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;


}
