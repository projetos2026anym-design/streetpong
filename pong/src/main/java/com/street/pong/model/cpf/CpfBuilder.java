package com.street.pong.model.cpf;

import com.street.pong.model.exceptions.ConditionFailedException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CpfBuilder {
    private String numero;

    public Cpf toBuild() {
        if (this.numero == null) {
            throw new ConditionFailedException("Cpf sem digitos");
        }
        return new Cpf(this);
    }
}
