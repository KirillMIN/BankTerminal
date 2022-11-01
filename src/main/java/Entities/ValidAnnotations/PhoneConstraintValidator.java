package Entities.ValidAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
        if(phoneField == null) {
            return false;
        }
        if(!phoneField.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")){
            System.out.println("bad choice");
            //здесь будет обработка  такого варианта и замена телефона
        }
        return phoneField.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }

}
