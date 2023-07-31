package be.bnair.springdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.entities.Ingredient;
import be.bnair.springdemo.models.entities.Plat;
import be.bnair.springdemo.models.form.PlatForm;
import be.bnair.springdemo.repository.IngredientRepository;
import be.bnair.springdemo.repository.PlatRepository;
import be.bnair.springdemo.service.PlatService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PlatServiceImpl implements PlatService{
    private final PlatRepository platRepository;
    private final IngredientRepository ingredientRepository;

    public PlatServiceImpl(PlatRepository platRepository, IngredientRepository ingredientRepository) {
        this.platRepository = platRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(PlatForm form) {
        Plat plat = new Plat();
        plat.setName(form.getNom());
        plat.setIngredient(form.getIngredients().stream()
        .map(id -> ingredientRepository.findById(id).orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList()));
        platRepository.save(plat);
    }

    @Override
    public List<PlatDTO> getAll() {
        return platRepository.findAll().stream()
        .map(plat -> PlatDTO.toDTO(plat)).toList();
    }

    @Override
    public void update(PlatForm form, Long id) {
        Optional<Plat> platOptional = platRepository.findById(id);
        if(platOptional.isPresent()) {
            platOptional.get().setIngredient(new ArrayList<Ingredient>());

            platOptional.get().setName(form.getNom());
            platOptional.get().setIngredient(new ArrayList<Ingredient>());

            for(long ingredientId : form.getIngredients()) {
                Optional<Ingredient> ing = ingredientRepository.findById(ingredientId);
                if(ing.isPresent() && !platOptional.get().getIngredient().contains(ing.get())) {
                    platOptional.get().addIngredient(ing.get());
                }
            }
            
            platRepository.save(platOptional.get());
        }
    }

    @Override
    public void delete(long id) {
        platRepository.deleteById(id);
    }

    @Override
    public PlatDTO getOne(long id) {
        Optional<Plat> plat = platRepository.findById(id);
        if(plat.isPresent()) {
            return PlatDTO.toDTO(plat.get());
        } else {
            throw new EntityNotFoundException("Plat " + id + " does not exist");
        }
    }
}
