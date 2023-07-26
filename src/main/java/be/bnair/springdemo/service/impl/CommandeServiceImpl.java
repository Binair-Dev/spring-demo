package be.bnair.springdemo.service.impl;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.repository.CommandeRepository;
import be.bnair.springdemo.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
}
