package com.street.pong.dataproviders;

import com.street.pong.model.endereco.EnderecoTO;

import java.util.UUID;

public class EnderecoTODataProvider {

    public static EnderecoTO createEnderecoTO() {
        return new EnderecoTO(
                UUID.randomUUID(),
                "Rua das Palmeiras",
                "123",
                "Centro",
                "Maringá",
                "PR",
                "87010-000",
                null
        );
    }
}
