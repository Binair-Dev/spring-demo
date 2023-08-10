package be.bnair.springdemo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int pageSize;
    private List<String> keywords;

    @OneToOne
    private MainAuthorEntity mainAuthor;

    @OneToOne
    private OratorEntity orator;
    
    @OneToMany
    private List<AuthorEntity> authors;

    @OneToMany
    private List<NoteEntity> notes;
}