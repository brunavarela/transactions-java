package br.com.bruna.learningspring.dto;
// Data Transfer Object (vai descrever as entidades e seus comportamentos),
// vai ter a maior parte das regras de negocio de uma aplicação

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class CreateDepositDto {
    @NotNull(message = "Value cannot be null")
    @DecimalMin(value = "0.01", message = "Value must be higher than 0.01")
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
