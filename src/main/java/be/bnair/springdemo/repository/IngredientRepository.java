package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bnair.springdemo.models.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    
}
