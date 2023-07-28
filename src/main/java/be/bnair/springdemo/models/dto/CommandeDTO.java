package be.bnair.springdemo.models.dto;

import java.util.List;

import be.bnair.springdemo.models.entities.Commande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeDTO {
    private Long id;
    private List<PlatDTO> plats;
    private UserDTO user;

    public static CommandeDTO toDTO(Commande entity){
        if(entity == null)
            throw new RuntimeException();

        return CommandeDTO.builder()
                .id(entity.getId())
                .plats(entity.getPlats().stream()
                        .map(plat -> PlatDTO.toDTO(plat))
                        .toList())
                .user(UserDTO.toDTO(entity.getUser()))
                .build();

    }
}
