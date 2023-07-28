package be.bnair.springdemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.entities.Ingredient;
import be.bnair.springdemo.models.form.IngredientForm;
import be.bnair.springdemo.repository.IngredientRepository;
import be.bnair.springdemo.service.IngredientService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(IngredientForm plat) {
        Ingredient ingredient = new Ingredient(plat.getName(), plat.getQuantity());
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
        .map(ing -> IngredientDTO.toDTO(ing)).toList();
    }

    @Override
    public void update(IngredientForm form, Long id) {
        Optional<Ingredient> ingOptional = ingredientRepository.findById(id);
        if(ingOptional.isPresent()) {
            ingOptional.get().setName(form.getName());
            ingOptional.get().setQuantity(form.getQuantity());
            ingredientRepository.save(ingOptional.get());
        }
    }

    @Override
    public void delete(long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public IngredientDTO getOne(long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            return IngredientDTO.toDTO(ingredient.get());
        } else {
            throw new EntityNotFoundException("Ingredient " + id + " does not exist");
        }
    }
}
