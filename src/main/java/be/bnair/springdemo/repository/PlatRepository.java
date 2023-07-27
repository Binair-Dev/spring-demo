package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bnair.springdemo.models.entities.Plat;

public interface PlatRepository extends JpaRepository<Plat, Long>{
    
}
