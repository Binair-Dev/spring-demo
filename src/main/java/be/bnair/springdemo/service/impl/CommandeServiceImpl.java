package be.bnair.springdemo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.CommandeDTO;
import be.bnair.springdemo.models.entities.Commande;
import be.bnair.springdemo.models.entities.User;
import be.bnair.springdemo.models.form.CommandeForm;
import be.bnair.springdemo.repository.CommandeRepository;
import be.bnair.springdemo.repository.PlatRepository;
import be.bnair.springdemo.repository.UserRepository;
import be.bnair.springdemo.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
    private final CommandeRepository commandeRepository;
    private final UserRepository userRepository;
    private final PlatRepository platRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository, UserRepository userRepository,
    PlatRepository platRepository) {
        this.commandeRepository = commandeRepository;
        this.userRepository = userRepository;
        this.platRepository = platRepository;
    }

    @Override
    public void create(CommandeForm user) {
        Commande cmd = new Commande();
        Optional<User> dto = userRepository.findById(user.getUser());
        if(dto.isPresent()) {
            cmd.setUser(dto.get());
        }
        cmd.setPlats(user.getPlats().stream()
        .map(id -> platRepository.findById(id).orElse(null))
        .filter(Objects::nonNull)
        .collect(Collectors.toList()));
        commandeRepository.save(cmd);
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
        Optional<Commande> cmd = commandeRepository.findById(id);

        if(cmd.isPresent()) {
            Optional<User> dto = userRepository.findById(form.getUser());
            cmd.get().setUser(dto.get());
            cmd.get().setPlats(form.getPlats().stream()
            .map(i -> platRepository.findById(i).orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toList()));

            commandeRepository.save(cmd.get());
        }
    }
}
