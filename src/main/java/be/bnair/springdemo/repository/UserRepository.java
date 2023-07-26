package be.bnair.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.bnair.springdemo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
