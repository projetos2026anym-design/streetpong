package com.street.pong.model.exceptions;

public class ConditionFailedException extends RuntimeException {
    public ConditionFailedException(String message) {
        super(message);
    }
}
