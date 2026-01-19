package com.street.pong.model.pessoa;

import com.street.pong.model.exceptions.ConditionFailedException;
import org.springframework.stereotype.Component;

@Component
public class PessoaValidate {


    public void validatePessoa(PessoaTO pessoaTO) {
        if (pessoaTO.dataNascimento() == null) {
            throw new ConditionFailedException("Obrigatório informar a data de nascimento");
        }
        if (pessoaTO.nome() == null || pessoaTO.nome().isBlank()) {
            throw new ConditionFailedException("Obrigatório informar o nome");
        }
        if (pessoaTO.endereco() == null) {
            throw new ConditionFailedException("Obrigatório informar o endereço");
        }
        if (pessoaTO.cpf() == null) {
            throw new ConditionFailedException("Obrigatório informar o CPF");
        }
        if (pessoaTO.telefone() == null) {
            throw new ConditionFailedException("Obrigatório informar o telefone");
        }
    }
}
