package be.bnair.springdemo.models.dto;

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
    private Set<IngredientDTO> ingredients;

    public static PlatDTO toDTO (Plat entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return PlatDTO.builder()
                .id(entity.getId())
                .nom(entity.getName())
                .ingredients(entity.getIngredient().stream()
                        .map(ingredient -> IngredientDTO.toDTO(ingredient))
                        .collect(Collectors.toSet())
                )
                .build();
    }
}



