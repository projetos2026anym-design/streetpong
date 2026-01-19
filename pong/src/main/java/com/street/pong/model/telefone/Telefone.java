package com.street.pong.model.telefone;

import com.street.pong.model.abstract_entities.UuidEntity;
import com.street.pong.model.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "telefone",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_telefone_ddd_numero",
                columnNames = {"ddd", "numero"}
        )
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Telefone extends UuidEntity {

//    @Id
//    @GeneratedValue
//    @Column(updatable = false, nullable = false)
//    private UUID id;

    @Column(nullable = false, length = 2)
    private String ddd;

    @Column(nullable = false, length = 9)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    public Telefone(TelefoneBuilder telefoneBuilder) {
        this.ddd = telefoneBuilder.getDdd();
        this.numero = telefoneBuilder.getNumero();
        this.pessoa = telefoneBuilder.getPessoa();
    }

    private boolean isValido(String ddd, String numero) {
        return ddd != null && ddd.matches("\\d{2}")
                && numero != null && numero.matches("\\d{8,9}");
    }

    public Telefone(String ddd, String numero, Pessoa pessoa) {
        if (!isValido(ddd, numero)) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        if (pessoa == null) {
            throw new IllegalArgumentException("Telefone precisa estar vinculado a uma pessoa");
        }
        this.ddd = ddd;
        this.numero = numero;
        this.pessoa = pessoa;
    }


    public String formatado() {
        return String.format("(%s) %s", ddd, numero);
    }
}
