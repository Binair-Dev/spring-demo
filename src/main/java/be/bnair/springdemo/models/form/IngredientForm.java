package be.bnair.springdemo.models.form;

import lombok.Data;

@Data
public class IngredientForm {
    private long id;
    private String name;
    private double quantity;
    private boolean isChecked;

    public IngredientForm(long id, String name, double quantity, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.isChecked = isChecked;
    }

     public IngredientForm() {}
}
