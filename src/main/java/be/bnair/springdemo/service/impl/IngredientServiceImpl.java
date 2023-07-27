package be.bnair.springdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.entities.Ingredient;
import be.bnair.springdemo.repository.IngredientRepository;
import be.bnair.springdemo.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(Ingredient plat) {

    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
        .map(ing -> IngredientDTO.toDTO(ing)).toList();
    }

    @Override
    public void update(Ingredient plat, Long id) {
        
    }

    @Override
    public void delete(long id) {
        ingredientRepository.deleteById(id);
    }
}
