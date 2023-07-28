package be.bnair.springdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.CommandeDTO;
import be.bnair.springdemo.models.entities.User;
import be.bnair.springdemo.models.form.CommandeForm;
import be.bnair.springdemo.repository.CommandeRepository;
import be.bnair.springdemo.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public void create(CommandeForm user) {
        //TODO: save commande
    }

    @Override
    public List<CommandeDTO> getAllByUser(User user) {
        return commandeRepository.findAll().stream()
        .filter(command -> command.getUser().getId() == user.getId())
        .map(cmd -> CommandeDTO.toDTO(cmd))
        .toList();
    }

    @Override
    public List<CommandeDTO> getAll() {
        return commandeRepository.findAll().stream()
        .map(cmd -> CommandeDTO.toDTO(cmd))
        .toList();
    }

    @Override
    public void update(CommandeForm form, long id) {
        //TODO: update commande
    }
}
