package com.ingresso.ingresso.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SemTresLetrasConsecutivasValidator implements ConstraintValidator<SemTresLetrasConsecutivas, String> {
    @Override
    public void initialize(SemTresLetrasConsecutivas constraintAnnotation){

    }

    @Override
    public boolean isValid(String nomeCompleto, ConstraintValidatorContext context) {
        String nomeCompletoUpper = nomeCompleto.toUpperCase();
        for(int i = 2; i < nomeCompletoUpper.length(); i ++) {
            char a = nomeCompletoUpper.charAt(i);
            char b = nomeCompletoUpper.charAt(i-1);
            char c = nomeCompletoUpper.charAt(i-2);

            if(a == b && b == c) return false;
        }
        return true;
    }

}
