package be.bnair.springdemo.models.dto;

import be.bnair.springdemo.models.entities.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {
    private Long id;
    private String name;
    private double quantity;

    public static IngredientDTO toDTO (Ingredient entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return IngredientDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .build();
    }
}

