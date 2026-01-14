package com.street.pong.model.email;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    private String endereco;


    public Email(String endereco) {
        if (!isValido(endereco)) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.endereco = endereco;
    }

    private boolean isValido(String email) {
        return Pattern
                .compile("^[A-Za-z0-9+_.-]+@(.+)$")
                .matcher(email)
                .matches();
    }


}
