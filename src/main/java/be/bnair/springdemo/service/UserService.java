package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.UserDTO;
import be.bnair.springdemo.models.entities.User;

public interface UserService {
    void create(User user);
    UserDTO getOne(Long id);
    List<UserDTO> getAll();
    void update(User form, long id);
}
