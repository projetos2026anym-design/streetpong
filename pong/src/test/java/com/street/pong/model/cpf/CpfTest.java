package com.street.pong.model.cpf;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CpfTest {

    @Test
    public void testeCpf() {
        CpfBuilder cpfBuilder = new CpfBuilder();
        cpfBuilder.setNumero("11085139999");
        Cpf build = cpfBuilder.toBuild();
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(build).isNotNull();
            s.assertThat(build.getNumero()).isEqualTo("11085139999");
        });
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "Cpf sem digitos")
    public void testCpfBuilderSemDigitos() {
        CpfBuilder cpfBuilderTwo = new CpfBuilder();
        cpfBuilderTwo.toBuild();
    }

}