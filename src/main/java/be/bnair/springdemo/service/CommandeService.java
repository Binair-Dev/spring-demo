package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.CommandeDTO;
import be.bnair.springdemo.models.entities.Commande;
import be.bnair.springdemo.models.entities.User;

public interface CommandeService {
    void create(Commande user);
    List<CommandeDTO> getAllByUser(User user);
    List<CommandeDTO> getAll();
    void update(Commande form, long id);
}
