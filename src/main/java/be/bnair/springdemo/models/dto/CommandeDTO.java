package be.bnair.springdemo.models.dto;

import be.bnair.springdemo.models.entities.Commande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeDTO {
    private long id;
    private UserDTO user;

    public static CommandeDTO toDTO(Commande entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return CommandeDTO.builder()
                .id(entity.getId())
                .user(UserDTO.toDTO(entity.getUser()))
                .build();
    }
}
