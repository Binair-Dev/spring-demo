package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.entities.Ingredient;

public interface IngredientService {
    void create(Ingredient plat);
    List<IngredientDTO> getAll();
    void update(Ingredient plat, Long id);
    void delete(long id);
}
