package be.bnair.springdemo.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class OratorEntity extends AuthorEntity {
    private List<String> resume;
}