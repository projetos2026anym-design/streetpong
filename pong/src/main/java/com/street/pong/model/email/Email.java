package com.street.pong.model.email;

import com.street.pong.model.exceptions.ConditionFailedException;
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

    private boolean isValido(String email) {
        return Pattern
                .compile("^[A-Za-z0-9+_.-]+@(.+)$")
                .matcher(email)
                .matches();
    }

    public Email(EmailBuilder emailBuilder) {
        if (!isValido(endereco)) {
            throw new ConditionFailedException("E-mail inválido");
        }
        this.endereco = emailBuilder.getEndereco();
    }
}
