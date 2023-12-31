package be.bnair.springdemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.UserDTO;
import be.bnair.springdemo.models.entities.User;
import be.bnair.springdemo.models.form.UserForm;
import be.bnair.springdemo.repository.UserRepository;
import be.bnair.springdemo.service.UserService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserForm form) {
        User user = new User(form.getNom(), form.getPrenom(), form.getDate_de_naissance(), form.getPassword());
        userRepository.save(user);
    }

    @Override
    public UserDTO getOne(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return UserDTO.toDTO(user.get());
        } else {
            throw new EntityNotFoundException("User " + id + " does not exist");
        }
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
        .map(user -> UserDTO.toDTO(user)).toList();
    }

    @Override
    public void update(UserForm form, long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            user.get().setNom(form.getNom());
            user.get().setPrenom(form.getPrenom());
            user.get().setDate_de_naissance(form.getDate_de_naissance());
            user.get().setPassword(form.getPassword());
            userRepository.save(user.get());
        }
    }
}
