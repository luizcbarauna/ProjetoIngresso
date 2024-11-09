package com.ingresso.ingresso.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AniversarioValidator implements ConstraintValidator<AniversarioValido, String> {

    @Override
    public boolean isValid(String localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) {
            return false; // Se a data for nula, consideramos inválida
        }
        try {
            LocalDate dataNascimento = LocalDate.parse(localDate, DateTimeFormatter.ISO_LOCAL_DATE);

        return !dataNascimento.isAfter(LocalDate.now());
        }catch (Exception e){
            return false;
        }
    }

}
