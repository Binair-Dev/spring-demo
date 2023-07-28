package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.UserDTO;
import be.bnair.springdemo.models.form.UserForm;

public interface UserService {
    void create(UserForm user);
    UserDTO getOne(Long id);
    List<UserDTO> getAll();
    void update(UserForm form, long id);
}
