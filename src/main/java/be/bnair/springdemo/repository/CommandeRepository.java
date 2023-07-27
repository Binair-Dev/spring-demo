package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bnair.springdemo.models.entities.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Long>{
    
}
