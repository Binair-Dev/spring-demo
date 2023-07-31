package be.bnair.springdemo.models.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PlatForm {
    private String nom;
    private List<Long> ingredients;

    public PlatForm(String nom) {
        this.nom = nom;
        this.ingredients = new ArrayList<>();
    }

    public PlatForm() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(long id) {
        if(!ingredients.contains(id))
            ingredients.add(id);
    }
}
