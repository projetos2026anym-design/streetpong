package com.street.pong.model.endereco;

import com.street.pong.model.exceptions.ConditionFailedException;
import com.street.pong.model.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EnderecoValidator {
    public void validateEndereco(EnderecoTO enderecoTO) {
        if (enderecoTO.logradouro() == null || enderecoTO.numero() == null || enderecoTO.bairro() == null || enderecoTO.cidade() == null ||
                enderecoTO.estado() == null || enderecoTO.cep() == null) {
            throw new IllegalArgumentException("Todos os campos obrigatórios devem ser preenchidos");
        }
        if(enderecoTO.logradouro().isBlank() || enderecoTO.numero().isBlank() || enderecoTO.bairro().isBlank() || enderecoTO.cidade().isBlank() ||
                enderecoTO.estado().isBlank() || enderecoTO.cep().isBlank()){
            throw new ConditionFailedException("Todos os campos obrigatórios devem ser preenchidos");
        }
    }
}
