package Entities.ValidAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if(phoneField == null) {
            return false;
        }
        if(!phoneField.matches("^((([0-9A-Za-z]{1}[-0-9A-z\\.]{0,30}[0-9A-Za-z]?)|([0-9А-Яа-я]{1}[-0-9А-я\\.]" +
                "{0,30}[0-9А-Яа-я]?))@([-A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$")){
            System.out.println("bad choice");
            //здесь будет обработка  такого варианта и замена телефона
        }
        return phoneField.matches("^((([0-9A-Za-z]{1}[-0-9A-z\\.]{0,30}[0-9A-Za-z]?)|([0-9А-Яа-я]{1}" +
                "[-0-9А-я\\.]{0,30}[0-9А-Яа-я]?))@([-A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$");
    }

}