package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.bnair.springdemo.entities.Plat;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Long>{
    
}
