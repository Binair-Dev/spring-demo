package be.bnair.springdemo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "note")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}