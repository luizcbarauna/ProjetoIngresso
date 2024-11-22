package com.ingresso.ingresso.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class EstadoBrasilValidator implements ConstraintValidator<EstadoBrasil, String> {
    private Set<String> estados = Set.of(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
            "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    );

    @Override
    public void initialize(EstadoBrasil constraintAnnotation){
    }

    @Override
    public boolean isValid(String estado, ConstraintValidatorContext context) {
        if(estados.contains(estado)) return true;
        return false;
    }
}
