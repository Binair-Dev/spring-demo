package be.bnair.springdemo.models.dto;

import java.time.LocalDate;

import be.bnair.springdemo.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    
    private long id;
    private String nom;
    private String prenom;
    private LocalDate date_de_naissance;

    public static UserDTO toDTO(User entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return UserDTO.builder()
                .id(entity.getId())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .date_de_naissance(entity.getDate_de_naissance())
                .build();
    }
}
