package br.com.itau.modulochavepix.api.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.itau.modulochavepix.exception.BusinessException;
import org.junit.jupiter.api.Test;

class ChavePixValidatorTest {
    @Test
    void testCheckTipoChave() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave("Tipo Chave"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave(""));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave(null));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave("Tipo Chave"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave(""));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoChave(null));
    }

    @Test
    void testCheckTipoChave2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("celular");
    }

    @Test
    void testCheckTipoChave3() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("email");
    }

    @Test
    void testCheckTipoChave4() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("cpf");
    }

    @Test
    void testCheckTipoChave5() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("cnpj");
    }

    @Test
    void testCheckTipoChave6() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("aleatorio");
    }

    @Test
    void testCheckTipoChave7() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("celular");
    }

    @Test
    void testCheckTipoChave8() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("email");
    }

    @Test
    void testCheckTipoChave9() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("cpf");
    }

    @Test
    void testCheckTipoChave10() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("cnpj");
    }

    @Test
    void testCheckTipoChave11() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoChave(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoChave("aleatorio");
    }

    @Test
    void testCheckTipoConta() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoConta("Tipo Conta"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator())
                .checkTipoConta("Valores de tipo de conta inválidos! Deve ser 'corrente' ou 'poupanca'"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoConta(""));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoConta(null));
    }

    @Test
    void testCheckTipoConta2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoConta(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoConta("corrente");
    }

    @Test
    void testCheckTipoConta3() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoConta(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoConta("poupanca");
    }

    @Test
    void testCheckNumeroAgencia() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkNumeroAgencia(Long)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkNumeroAgencia(1L);
    }

    @Test
    void testCheckNumeroAgencia2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkNumeroAgencia(Long)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkNumeroAgencia(0L);
    }

    @Test
    void testCheckNumeroAgencia3() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroAgencia(null));
    }

    @Test
    void testCheckNumeroAgencia4() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroAgencia(Long.MAX_VALUE));
    }

    @Test
    void testCheckNumeroConta() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkNumeroConta(Long)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkNumeroConta(1L);
    }

    @Test
    void testCheckNumeroConta2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkNumeroConta(Long)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkNumeroConta(0L);
    }

    @Test
    void testCheckNumeroConta3() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroConta(null));
    }

    @Test
    void testCheckNumeroConta4() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroConta(Long.MAX_VALUE));
    }

    @Test
    void testCheckChaveValorGenerica() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkChaveValorGenerica(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkChaveValorGenerica("Chave Valor");
    }

    @Test
    void testCheckChaveValorGenerica2() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkChaveValorGenerica(""));
    }

    @Test
    void testCheckChaveValorGenerica3() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkChaveValorGenerica(null));
    }

    @Test
    void testCheckNumeroCelular() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroCelular("Numero Celular"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNumeroCelular("+55"));
        assertThrows(BusinessException.class,
                () -> (new ChavePixValidator()).checkNumeroCelular("O telefone deve conter o código de país '+55'!"));
    }

    @Test
    void testCheckEmail() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkEmail(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkEmail("jane.doe@example.org");
    }

    @Test
    void testCheckEmail2() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkEmail("Email"));
    }

    @Test
    void testCheckCPF() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkCPF("Cpf"));
    }

    @Test
    void testCheckCPF2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkCPF(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkCPF("Cpfcorrente");
    }

    @Test
    void testCheckCNPJ() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkCNPJ("Cnpj"));
    }

    @Test
    void testCheckCNPJ2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkCNPJ(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkCNPJ("aleatorioemail");
    }

    @Test
    void testCheckChaveAleatoria() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkChaveAleatoria(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkChaveAleatoria("Chave Aleatoria");
    }

    @Test
    void testCheckChaveAleatoria2() throws BusinessException {
        assertThrows(BusinessException.class,
                () -> (new ChavePixValidator()).checkChaveAleatoria("Chave AleatoriaChave AleatoriaChave Aleatoria"));
    }

    @Test
    void testCheckTipoPessoa() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoPessoa("Tipo Pessoa"));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoPessoa(""));
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkTipoPessoa(null));
    }

    @Test
    void testCheckTipoPessoa2() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoPessoa(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoPessoa("fisica");
    }

    @Test
    void testCheckTipoPessoa3() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkTipoPessoa(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkTipoPessoa("juridica");
    }

    @Test
    void testCheckNomeCorrentista() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by checkNomeCorrentista(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        (new ChavePixValidator()).checkNomeCorrentista("Name");
    }

    @Test
    void testCheckNomeCorrentista2() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNomeCorrentista(""));
    }

    @Test
    void testCheckNomeCorrentista3() throws BusinessException {
        assertThrows(BusinessException.class, () -> (new ChavePixValidator()).checkNomeCorrentista(null));
    }
}

