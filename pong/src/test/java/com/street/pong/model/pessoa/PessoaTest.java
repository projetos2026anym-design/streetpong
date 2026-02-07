package com.street.pong.model.pessoa;

import com.street.pong.dataproviders.PessoaTODataProvider;
import com.street.pong.model.cpf.CpfBuilder;
import org.assertj.core.api.SoftAssertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
public class PessoaTest {

    @MockitoBean
    private PessoaService pessoaService;

    @Test
    public void payloadPessoa() {
        CpfBuilder cpf = new CpfBuilder();
        cpf.setNumero("43425675800");

        PessoaTO pessoaTO = PessoaTODataProvider.createPessoaTO(UUID.randomUUID(), "Jorge", null,
                null, null, cpf.toBuild(), LocalDateTime.now());

        PessoaTO toReturnPessoaTO = pessoaService.payloadPessoa(pessoaTO);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(toReturnPessoaTO).isNotNull();
            s.assertThat(toReturnPessoaTO.nome()).isEqualTo("Jorge");
            s.assertThat(toReturnPessoaTO.dataNascimento()).isEqualTo(LocalDateTime.now());
            s.assertThat(toReturnPessoaTO.cpf()).isEqualTo("43425675800");
            s.assertThat(toReturnPessoaTO.telefone()).isNull();
            s.assertThat(toReturnPessoaTO.email()).isNull();
            s.assertThat(toReturnPessoaTO.endereco()).isNull();
        });
    }

}
