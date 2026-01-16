package com.street.pong.model.pessoa;

import com.street.pong.model.cpf.Cpf;
import com.street.pong.model.email.Email;
import com.street.pong.model.endereco.Endereco;
import com.street.pong.model.telefone.Telefone;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PessoaBuilder {
    private String nome;
    private Email email;
    private Endereco endereco;
    private Cpf cpf;
    private LocalDateTime dataNascimento;
    private Telefone telefone;

    public Pessoa toBuild() {
        return new Pessoa(this);
    }
}
