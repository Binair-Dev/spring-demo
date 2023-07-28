package be.bnair.springdemo.models.dto;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import be.bnair.springdemo.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate date_de_naissance;
    private Set<Long> commandes;

    public static UserDTO toDTO(User entity){
        if(entity == null)
            throw  new IllegalArgumentException("Ne peut etre null");

        return UserDTO.builder()
                .id(entity.getId())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .date_de_naissance(entity.getDate_de_naissance())
                .commandes(entity.getCommandes().stream()
                        .map(commande -> commande.getId())
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
