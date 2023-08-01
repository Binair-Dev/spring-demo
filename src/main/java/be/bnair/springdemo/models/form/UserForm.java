package be.bnair.springdemo.models.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import be.bnair.springdemo.utils.Validators.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    @NotNull
    @NotBlank
    private String nom;

    @NotNull
    @NotBlank
    private String prenom;

    @Past(message = "Tu ne peux pas être né demain!")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_de_naissance;

    @Size(min = 3, message = "Password should have at least 3 characters.")
    @PasswordMatches
    private String password;

    @Size(min = 3)
    private String confirmPassword;
}
