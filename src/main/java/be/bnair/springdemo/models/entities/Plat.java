package be.bnair.springdemo.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Plat {
    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter @Setter
    private String name;

    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredient;

    public List<Ingredient> getIngredient() {
        return List.copyOf(ingredient);
    }

    public Plat(String name) {
        this.name = name;
        this.ingredient = new ArrayList<Ingredient>();
    }

    public Plat(String name, List<Ingredient> ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    public void addIngredient(Ingredient ingredient) {
        if(!this.ingredient.contains(ingredient))
            this.ingredient.add(ingredient);
    }
}