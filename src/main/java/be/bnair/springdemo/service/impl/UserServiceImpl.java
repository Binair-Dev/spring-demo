package be.bnair.springdemo.service.impl;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.repository.UserRepository;
import be.bnair.springdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
