package be.bnair.springdemo.models.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import be.bnair.springdemo.models.entities.Plat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlatDTO {
    private Long id;
    private String nom;
    private List<IngredientDTO> ingredients;

    public static PlatDTO toDTO (Plat entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return PlatDTO.builder()
                .id(entity.getId())
                .nom(entity.getName())
                .ingredients(entity.getIngredient().stream()
                        .map(IngredientDTO::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public void addIngredient(IngredientDTO ingredientDTO) {
        this.ingredients.add(ingredientDTO);
    }
}



