package be.bnair.springdemo.utils.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.bnair.springdemo.models.form.UserForm;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordMatches, UserForm> {

    @Override
    public boolean isValid(UserForm form, ConstraintValidatorContext context) {
        if (form == null) {
            return false;
        }

        return form.getPassword() != null && form.getPassword().equals(form.getConfirmPassword());
    }
}
