package be.bnair.springdemo.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class ExpertEntity extends MainAuthorEntity {
    private String address;

    @OneToMany
    private List<NoteEntity> notes;
}