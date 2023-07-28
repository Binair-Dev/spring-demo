package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.CommandeDTO;
import be.bnair.springdemo.models.entities.User;
import be.bnair.springdemo.models.form.CommandeForm;

public interface CommandeService {
    void create(CommandeForm user);
    List<CommandeDTO> getAllByUser(User user);
    List<CommandeDTO> getAll();
    void update(CommandeForm form, long id);
}
