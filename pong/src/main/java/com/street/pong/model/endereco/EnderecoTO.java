package com.street.pong.model.endereco;

import java.util.UUID;

public record EnderecoTO(UUID uuid,
                         String logradouro,
                         String numero,
                         String bairro,
                         String cidade,
                         String estado,
                         String cep,
                         String complemento) {

    public static EnderecoTO of(Endereco endereco) {
        return new EnderecoTO(
                endereco.getUuid(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento()
        );
    }
}
