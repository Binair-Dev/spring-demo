package be.bnair.springdemo.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String SSN;
    private String firstName;
    private String lastName;
    private String title;
    private String employer;

    @OneToMany
    private List<ArticleEntity> articles;
}