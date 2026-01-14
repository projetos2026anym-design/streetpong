package com.street.pong.service;

import com.street.pong.model.abstract_entities.UuidEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.UUID;


@Transactional
@RequiredArgsConstructor
public abstract class SuperService<T extends UuidEntity, I extends Serializable> {

    protected final JpaRepository<T, I> repository;

    public T save(T entidade) {
        if (entidade.getUuid() == null) {
            entidade.setUuid(UUID.randomUUID());
        }
        return repository.save(entidade);
    }

    public T findById(I id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public void delete(T entidade) {
        repository.delete(entidade);
    }
}

