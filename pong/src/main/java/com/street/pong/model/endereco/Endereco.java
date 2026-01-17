package com.street.pong.model.endereco;

import com.street.pong.model.abstract_entities.UuidEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "endereco",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_endereco_completo",
                columnNames = {"logradouro", "numero", "bairro", "cidade", "estado", "cep"}
        )
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Endereco extends UuidEntity {

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 9)
    private String cep;

    private String complemento;

    public Endereco(EnderecoBuilder enderecoBuilder) {
        this.logradouro = enderecoBuilder.getLogradouro();
        this.numero = enderecoBuilder.getNumero();
        this.bairro = enderecoBuilder.getBairro();
        this.cidade = enderecoBuilder.getCidade();
        this.estado = enderecoBuilder.getEstado();
        this.cep = enderecoBuilder.getComplemento();
        this.complemento = enderecoBuilder.getComplemento();
    }

    public EnderecoBuilder toBuilder() {
        return new EnderecoBuilder(this);
    }
}
