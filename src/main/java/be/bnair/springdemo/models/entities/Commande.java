package be.bnair.springdemo.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Commande {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @ManyToMany
    @JoinTable(
        name = "commande_plat",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "plat_id")
    )
    private List<Plat> plats;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "personne_id")
    private User user;

    public List<Plat> getPlats() {
        return List.copyOf(plats);
    }

    public Commande(User user) {
        this.user = user;
        this.plats = new ArrayList<Plat>();
    }

    public Commande(User user, Plat plat) {
        this.user = user;
        this.plats = new ArrayList<Plat>();
        this.plats.add(plat);
    }
}
