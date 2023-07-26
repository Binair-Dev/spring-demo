package be.bnair.springdemo.service.impl;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.repository.PlatRepository;
import be.bnair.springdemo.service.PlatService;

@Service
public class PlatServiceImpl implements PlatService{
    private final PlatRepository platRepository;

    public PlatServiceImpl(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }
}
