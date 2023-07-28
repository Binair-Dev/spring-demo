package be.bnair.springdemo.service;

import java.util.List;

import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.form.PlatForm;

public interface PlatService {
    void create(PlatForm plat);
    List<PlatDTO> getAll();
    PlatDTO getOne(long id);
    void update(PlatForm plat, Long id);
    void delete(long id);
}
