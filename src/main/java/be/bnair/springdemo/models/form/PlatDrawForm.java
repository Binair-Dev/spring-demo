package be.bnair.springdemo.models.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PlatDrawForm {
    private String nom;
    private List<IngredientForm> ingredients;

    public PlatDrawForm() {
        this.ingredients = new ArrayList<IngredientForm>();
    }
}
