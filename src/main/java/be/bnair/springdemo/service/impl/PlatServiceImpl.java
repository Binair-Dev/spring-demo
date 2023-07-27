package be.bnair.springdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.entities.Plat;
import be.bnair.springdemo.repository.PlatRepository;
import be.bnair.springdemo.service.PlatService;

@Service
public class PlatServiceImpl implements PlatService{
    private final PlatRepository platRepository;

    public PlatServiceImpl(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    @Override
    public void create(Plat plat) {

    }

    @Override
    public List<PlatDTO> getAll() {
        return platRepository.findAll().stream()
        .map(plat -> PlatDTO.toDTO(plat)).toList();
    }

    @Override
    public void update(Plat plat, Long id) {
        
    }

    @Override
    public void delete(long id) {
        platRepository.deleteById(id);
    }
}
