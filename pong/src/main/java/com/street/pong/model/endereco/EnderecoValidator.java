package com.street.pong.model.endereco;

import org.springframework.stereotype.Component;

@Component
public class EnderecoValidator {
    public void isNullField(Endereco endereco) {
        if (endereco.getLogradouro() == null || endereco.getNumero() == null || endereco.getBairro() == null || endereco.getCidade() == null ||
                endereco.getEstado() == null || endereco.getCep() == null) {
            throw new IllegalArgumentException("Todos os campos obrigatórios devem ser preenchidos");
        }
    }
}
