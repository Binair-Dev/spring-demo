package be.bnair.springdemo.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "personne")
@NoArgsConstructor
public class User {
    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter @Setter
    private String nom;

    @Getter @Setter
    private String prenom;

    @Getter @Setter
    private LocalDate date_de_naissance;

    @Setter
    @OneToMany(mappedBy = "user")
    private List<Commande> commandes; 

    public List<Commande> getCommandes() {
        return List.copyOf(commandes);
    }

    public void addCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public User(String nom, String prenom, LocalDate date_de_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.commandes = new ArrayList<Commande>();
    }
}