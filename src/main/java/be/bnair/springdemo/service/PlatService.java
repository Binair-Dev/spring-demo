package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.entities.Plat;

public interface PlatService {
    void create(Plat plat);
    List<PlatDTO> getAll();
    void update(Plat plat, Long id);
    void delete(long id);
}
