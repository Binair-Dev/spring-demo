package be.bnair.springdemo.service.impl;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.repository.IngredientRepository;
import be.bnair.springdemo.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
}
