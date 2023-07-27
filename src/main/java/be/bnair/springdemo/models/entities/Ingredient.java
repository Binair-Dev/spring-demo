package be.bnair.springdemo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
public class Ingredient {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double quantity;

    public Ingredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
