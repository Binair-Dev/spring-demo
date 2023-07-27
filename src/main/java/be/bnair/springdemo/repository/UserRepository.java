package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bnair.springdemo.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
