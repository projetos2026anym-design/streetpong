package com.street.pong.model.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(String.format("%s não encontrado", message));
    }
}
