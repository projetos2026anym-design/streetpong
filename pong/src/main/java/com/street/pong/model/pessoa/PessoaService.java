package com.street.pong.model.pessoa;

import com.street.pong.model.exceptions.EntityNotFoundException;
import com.street.pong.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Service
public class PessoaService extends SuperService<Pessoa, UUID> {
    public PessoaService(PessoaRepository pessoaRepository) {
        super(pessoaRepository);
    }

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaValidate pessoaValidate;

    public PessoaTO payloadPessoa(PessoaTO pessoaTO) {
        PessoaBuilder pessoaBuilder = new PessoaBuilder();
        pessoaBuilder.setNome(pessoaTO.nome());
        pessoaBuilder.setEmail(pessoaTO.email());
        pessoaBuilder.setCpf(pessoaTO.cpf());
        pessoaBuilder.setEndereco(pessoaTO.endereco());
        pessoaBuilder.setTelefone(pessoaTO.telefone());
        pessoaBuilder.setDataNascimento(pessoaTO.dataNascimento());

        Pessoa build = pessoaBuilder.toBuild();
//        pessoaRepository.save(build);
        return PessoaTO.of(build);
    }

    public PessoaTO updatePessoa(PessoaTO pessoaTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaTO.uuid());
        if (optionalPessoa.isEmpty()) {
            throw new EntityNotFoundException("Pessoa");
        }
        pessoaValidate.validatePessoa(pessoaTO);

        PessoaBuilder pessoaBuilder = optionalPessoa.get().toBuilder();
        pessoaBuilder.setNome(ofNullable(pessoaTO.nome()).orElse(pessoaBuilder.getNome()));
        pessoaBuilder.setEmail(ofNullable(pessoaTO.email()).orElse(pessoaBuilder.getEmail()));
        pessoaBuilder.setCpf(ofNullable(pessoaTO.cpf()).orElse(pessoaBuilder.getCpf()));
        pessoaBuilder.setEndereco(ofNullable(pessoaTO.endereco()).orElse(pessoaBuilder.getEndereco()));
        pessoaBuilder.setTelefone(ofNullable(pessoaTO.telefone()).orElse(pessoaBuilder.getTelefone()));
        pessoaBuilder.setDataNascimento(ofNullable(pessoaTO.dataNascimento()).orElse(pessoaBuilder.getDataNascimento()));
        return PessoaTO.of(pessoaRepository.save(pessoaBuilder.toBuild()));
    }
}
