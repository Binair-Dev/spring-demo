package be.bnair.springdemo.models.form;

import java.util.List;

import lombok.Data;

@Data
public class CommandeForm {
    private List<Long> plats;
    private long user;
}
