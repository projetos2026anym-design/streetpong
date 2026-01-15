package com.street.pong.model.pessoa;

import com.street.pong.model.telefone.Telefone;
import com.street.pong.model.abstract_entities.UuidEntity;
import com.street.pong.model.cpf.Cpf;
import com.street.pong.model.email.Email;
import com.street.pong.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pessoa extends UuidEntity {

    private String nome;

    private Email email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Embedded
    private Cpf cpf;

    private LocalDateTime dataNascimento;

    @OneToOne
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    public Pessoa(PessoaBuilder pessoaBuilder) {
        this.nome =  pessoaBuilder.getNome();
        this.email = pessoaBuilder.getEmail();
        this.endereco = pessoaBuilder.getEndereco();
        this.cpf = pessoaBuilder.getCpf();
        this.dataNascimento = pessoaBuilder.getDataNascimento();
        this.telefone = pessoaBuilder.getTelefone();
    }

}
