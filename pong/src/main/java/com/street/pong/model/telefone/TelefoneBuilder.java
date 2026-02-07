package com.street.pong.model.telefone;

import com.street.pong.model.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TelefoneBuilder {
    private UUID id;
    private String ddd;
    private String numero;
    private Pessoa pessoa;

    public Telefone toBuild(){
        return new Telefone(this);
    }
}
