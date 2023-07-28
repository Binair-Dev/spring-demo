package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.form.IngredientForm;

public interface IngredientService {
    void create(IngredientForm plat);
    List<IngredientDTO> getAll();
    IngredientDTO getOne(long id);
    void update(IngredientForm plat, Long id);
    void delete(long id);
}
