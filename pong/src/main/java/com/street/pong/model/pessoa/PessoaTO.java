package com.street.pong.model.pessoa;

import com.street.pong.model.cpf.Cpf;
import com.street.pong.model.email.Email;
import com.street.pong.model.endereco.Endereco;
import com.street.pong.model.telefone.Telefone;

import java.time.LocalDateTime;
import java.util.UUID;

public record PessoaTO(UUID uuid, String nome, Email email, Endereco endereco, Telefone telefone, Cpf cpf,
                       LocalDateTime dataNascimento) {

    public static PessoaTO of(Pessoa pessoa) {
        return new PessoaTO(pessoa.getUuid(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getEndereco(),
                pessoa.getTelefone(),
                pessoa.getCpf(),
                pessoa.getDataNascimento());
    }
}
