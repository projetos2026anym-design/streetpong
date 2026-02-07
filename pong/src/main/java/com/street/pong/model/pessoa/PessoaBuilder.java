package com.street.pong.model.pessoa;

import com.street.pong.model.cpf.Cpf;
import com.street.pong.model.email.Email;
import com.street.pong.model.endereco.Endereco;
import com.street.pong.model.telefone.Telefone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PessoaBuilder {
    private String nome;
    private Email email;
    private Endereco endereco;
    private Cpf cpf;
    private LocalDateTime dataNascimento;
    private Telefone telefone;

    public PessoaBuilder(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.endereco = pessoa.getEndereco();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento();
        this.telefone = pessoa.getTelefone();
    }

    public Pessoa toBuild() {
        return new Pessoa(this);
    }
}
