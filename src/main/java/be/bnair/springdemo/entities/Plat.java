package be.bnair.springdemo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Plat {
    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter @Setter
    private String name;

    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredient;

    public List<Ingredient> getIngredient() {
        return List.copyOf(ingredient);
    }
}   