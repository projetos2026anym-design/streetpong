package com.street.pong.model.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailBuilder {
    private String endereco;

    public Email toBuild(){
        return new Email(this);
    }
}
