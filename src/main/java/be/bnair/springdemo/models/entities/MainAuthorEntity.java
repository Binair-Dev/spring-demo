package be.bnair.springdemo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class MainAuthorEntity extends AuthorEntity {
    private String phone;
    private String telecopy;
    private String email;
}