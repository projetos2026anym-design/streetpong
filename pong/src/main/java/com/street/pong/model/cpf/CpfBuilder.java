package com.street.pong.model.cpf;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CpfBuilder {
    private String numero;

    public Cpf toBuild() {
        if (this.numero == null) {
            throw new RuntimeException("Cpf sem digitos");
        }
        return new Cpf(this);
    }
}
