package com.street.pong.model.endereco;

import com.street.pong.model.exceptions.EntityNotFoundException;
import com.street.pong.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Service
public class EnderecoService extends SuperService<Endereco, UUID> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoValidator enderecoValidator;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        super(enderecoRepository);
    }

    public Endereco findByCidadeAndCepAndEstado(String cidade, String cep, String estado) {
        return enderecoRepository.findByCidadeCepEstado(cidade, cep, estado);
    }

    public EnderecoTO createEndereco(EnderecoTO enderecoTO) {
        enderecoValidator.validateEndereco(enderecoTO);
        EnderecoBuilder enderecoBuilder = new EnderecoBuilder();

        enderecoBuilder.setLogradouro(enderecoTO.logradouro());
        enderecoBuilder.setNumero(enderecoTO.numero());
        enderecoBuilder.setBairro(enderecoTO.bairro());
        enderecoBuilder.setCidade(enderecoTO.cidade());
        enderecoBuilder.setEstado(enderecoTO.estado());
        enderecoBuilder.setCep(enderecoTO.cep());
        enderecoBuilder.setComplemento(enderecoTO.complemento());

        Endereco build = enderecoBuilder.toBuild();
//        enderecoRepository.save(build)
        return EnderecoTO.of(build);
    }

    public EnderecoTO updateEndereco(EnderecoTO enderecoTO) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoTO.uuid());
        if (optionalEndereco.isEmpty()) {
            throw new EntityNotFoundException("Endereço");
        }
        EnderecoBuilder builder = optionalEndereco.get().toBuilder();
        builder.setLogradouro(ofNullable(enderecoTO.logradouro()).orElse(builder.getLogradouro()));
        builder.setNumero(ofNullable(enderecoTO.numero()).orElse(builder.getNumero()));
        builder.setBairro(ofNullable(enderecoTO.bairro()).orElse(builder.getBairro()));
        builder.setCidade(ofNullable(enderecoTO.cidade()).orElse(builder.getCidade()));
        builder.setEstado(ofNullable(enderecoTO.estado()).orElse(builder.getEstado()));
        builder.setCep(ofNullable(enderecoTO.cep()).orElse(builder.getCep()));
        builder.setComplemento(enderecoTO.complemento());
        Endereco save = enderecoRepository.save(builder.toBuild());
        return EnderecoTO.of(save);
    }
}
