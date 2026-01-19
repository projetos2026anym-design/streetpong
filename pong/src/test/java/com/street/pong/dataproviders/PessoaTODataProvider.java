package com.street.pong.dataproviders;

import com.street.pong.model.cpf.Cpf;
import com.street.pong.model.email.Email;
import com.street.pong.model.endereco.Endereco;
import com.street.pong.model.pessoa.PessoaTO;
import com.street.pong.model.telefone.Telefone;

import java.time.LocalDateTime;
import java.util.UUID;

public class PessoaTODataProvider {
    public static PessoaTO createPessoaTO(UUID uuid, String nome, Email email,
                                         Endereco endereco, Telefone telefone,
                                         Cpf cpf,
                                         LocalDateTime dataNascimento) {
        PessoaTO pessoaTO = new PessoaTO(
                uuid, nome, email, endereco, telefone, cpf, dataNascimento
        );
        return pessoaTO;
    }
}
