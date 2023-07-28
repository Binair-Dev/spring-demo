package be.bnair.springdemo.models.form;

import java.util.List;

import lombok.Data;

@Data
public class PlatForm {
    private String nom;
    private List<Long> ingredients;
}
