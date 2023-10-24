package br.com.bruna.learningspring.dto;
// Data Transfer Object (vai descrever as entidades e seus comportamentos),
// vai ter a maior parte das regras de negocio de uma aplicação

public class CreateDepositDto {
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
