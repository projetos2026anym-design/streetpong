package com.street.pong.model.endereco;

import com.street.pong.dataproviders.EnderecoTODataProvider;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@ActiveProfiles("test")
public class EnderecoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EnderecoService enderecoService;

    @Test
    public void createEndereco() {
        EnderecoTO enderecoTO = EnderecoTODataProvider.createEnderecoTO();

        EnderecoTO enderecoCreated = enderecoService.createEndereco(enderecoTO);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(enderecoCreated).isNotNull();
            s.assertThat(enderecoCreated.complemento()).isNull();
            s.assertThat(enderecoCreated.bairro()).isEqualTo("Centro");
        });
    }

    @Test
    public void updateEndereco() {
        EnderecoTO enderecoTO = EnderecoTODataProvider.createEnderecoTO();

        EnderecoTO enderecoCreated = enderecoService.createEndereco(enderecoTO);

        EnderecoTO newEnderecoTO = new EnderecoTO(
                enderecoCreated.uuid(),
                "Rua das Palmeiras",
                "666",
                "Rodovia",
                "Londrina",
                "PR",
                "87010-355",
                null
        );

        EnderecoTO toUpdateEnderecoTO = enderecoService.updateEndereco(newEnderecoTO);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(toUpdateEnderecoTO.logradouro()).isNotEqualTo(enderecoCreated.logradouro());
            s.assertThat(toUpdateEnderecoTO.numero()).isNotEqualTo(enderecoCreated.numero());
            s.assertThat(toUpdateEnderecoTO.cidade()).isNotEqualTo(enderecoCreated.cidade());
            s.assertThat(toUpdateEnderecoTO.cep()).isNotEqualTo(enderecoCreated.cep());
        });
    }
}
