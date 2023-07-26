package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.bnair.springdemo.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{
    
}
