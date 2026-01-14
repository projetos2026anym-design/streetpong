package com.street.pong.model.endereco;

import com.street.pong.model.abstract_entities.UuidEntity;
import jakarta.persistence.*;
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

    public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep, String complemento) {
        if (logradouro == null || numero == null || bairro == null || cidade == null || estado == null || cep == null) {
            throw new IllegalArgumentException("Todos os campos obrigatórios devem ser preenchidos");
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
    }
}
