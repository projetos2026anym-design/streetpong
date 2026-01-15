package com.street.pong.model.cpf;

import com.street.pong.model.exceptions.ConditionFailedException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cpf {

    private String numero;

    private boolean isValido(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        return cpf.length() == 11;
    }

    public Cpf(CpfBuilder cpfBuilder) {
        if (!isValido(cpfBuilder.getNumero())) {
            throw new ConditionFailedException("CPF inválido");
        }
        this.numero = cpfBuilder.getNumero();
    }
}

