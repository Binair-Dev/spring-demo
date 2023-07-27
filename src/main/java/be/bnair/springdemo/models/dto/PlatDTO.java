package be.bnair.springdemo.models.dto;

import be.bnair.springdemo.models.entities.Plat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlatDTO {
    private int id;
    private String name;

    public static PlatDTO toDTO(Plat entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return PlatDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
