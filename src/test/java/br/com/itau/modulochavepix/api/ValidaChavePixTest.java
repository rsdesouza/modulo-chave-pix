package br.com.itau.modulochavepix.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import br.com.itau.modulochavepix.api.validation.ChavePixValidator;
import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.exception.BusinessException;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ValidaChavePix.class, ValidaChavePix.CreatePixKeyFilterContextConfiguration.class})
@ExtendWith(SpringExtension.class)
class ValidaChavePixTest {
    @Autowired
    private ValidaChavePix.CreatePixKeyFilterContextConfiguration createPixKeyFilterContextConfiguration;

    @MockBean(name = "chavePixValidator")
    private ChavePixValidator chavePixValidator;

    @Autowired
    private ValidaChavePix validaChavePix;

    @Test
    void testCreatePixKeyFilterContextConfigurationChavePixValidator() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by chavePixValidator()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.createPixKeyFilterContextConfiguration.chavePixValidator();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testValidar() throws BusinessException {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at br.com.itau.modulochavepix.api.ValidaChavePix.validar(ValidaChavePix.java:36)
        //   In order to prevent validar(ChavePixDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   validar(ChavePixDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        this.validaChavePix.validar(new ChavePixDTO());
    }

    @Test
    void testValidar2() throws BusinessException {
        doNothing().when(this.chavePixValidator).checkNumeroCelular((String) any());
        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        this.validaChavePix.validar(new ChavePixDTO("celular", "celular", 1L, 1L, "celular", "celular", "celular",
                "celular", "celular", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
        verify(this.chavePixValidator).checkChaveValorGenerica((String) any());
        verify(this.chavePixValidator).checkNumeroAgencia((Long) any());
        verify(this.chavePixValidator).checkNumeroCelular((String) any());
        verify(this.chavePixValidator).checkNumeroConta((Long) any());
        verify(this.chavePixValidator).checkTipoChave((String) any());
        verify(this.chavePixValidator).checkTipoConta((String) any());
        verify(this.chavePixValidator).checkTipoPessoa((String) any());
    }

    @Test
    void testValidar3() throws BusinessException {
        doNothing().when(this.chavePixValidator).checkEmail((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroCelular((String) any());
        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        this.validaChavePix.validar(new ChavePixDTO("celular", "celular", 1L, 1L, "celular", "celular", "celular", "email",
                "celular", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
        verify(this.chavePixValidator).checkChaveValorGenerica((String) any());
        verify(this.chavePixValidator).checkEmail((String) any());
        verify(this.chavePixValidator).checkNumeroAgencia((Long) any());
        verify(this.chavePixValidator).checkNumeroConta((Long) any());
        verify(this.chavePixValidator).checkTipoChave((String) any());
        verify(this.chavePixValidator).checkTipoConta((String) any());
        verify(this.chavePixValidator).checkTipoPessoa((String) any());
    }

    @Test
    void testValidar4() throws BusinessException {
        doNothing().when(this.chavePixValidator).checkCPF((String) any());
        doNothing().when(this.chavePixValidator).checkEmail((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroCelular((String) any());
        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        this.validaChavePix.validar(new ChavePixDTO("celular", "celular", 1L, 1L, "celular", "celular", "celular", "cpf",
                "celular", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
        verify(this.chavePixValidator).checkCPF((String) any());
        verify(this.chavePixValidator).checkChaveValorGenerica((String) any());
        verify(this.chavePixValidator).checkNumeroAgencia((Long) any());
        verify(this.chavePixValidator).checkNumeroConta((Long) any());
        verify(this.chavePixValidator).checkTipoChave((String) any());
        verify(this.chavePixValidator).checkTipoConta((String) any());
        verify(this.chavePixValidator).checkTipoPessoa((String) any());
    }

    @Test
    void testValidar5() throws BusinessException {
        doNothing().when(this.chavePixValidator).checkCNPJ((String) any());
        doNothing().when(this.chavePixValidator).checkCPF((String) any());
        doNothing().when(this.chavePixValidator).checkEmail((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroCelular((String) any());
        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        this.validaChavePix.validar(new ChavePixDTO("celular", "celular", 1L, 1L, "celular", "celular", "celular", "cnpj",
                "celular", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
        verify(this.chavePixValidator).checkCNPJ((String) any());
        verify(this.chavePixValidator).checkChaveValorGenerica((String) any());
        verify(this.chavePixValidator).checkNumeroAgencia((Long) any());
        verify(this.chavePixValidator).checkNumeroConta((Long) any());
        verify(this.chavePixValidator).checkTipoChave((String) any());
        verify(this.chavePixValidator).checkTipoConta((String) any());
        verify(this.chavePixValidator).checkTipoPessoa((String) any());
    }

    @Test
    void testValidar6() throws BusinessException {
        doNothing().when(this.chavePixValidator).checkChaveAleatoria((String) any());
        doNothing().when(this.chavePixValidator).checkCNPJ((String) any());
        doNothing().when(this.chavePixValidator).checkCPF((String) any());
        doNothing().when(this.chavePixValidator).checkEmail((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroCelular((String) any());
        doNothing().when(this.chavePixValidator).checkChaveValorGenerica((String) any());
        doNothing().when(this.chavePixValidator).checkNumeroAgencia((Long) any());
        doNothing().when(this.chavePixValidator).checkNumeroConta((Long) any());
        doNothing().when(this.chavePixValidator).checkTipoChave((String) any());
        doNothing().when(this.chavePixValidator).checkTipoConta((String) any());
        doNothing().when(this.chavePixValidator).checkTipoPessoa((String) any());
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        this.validaChavePix.validar(new ChavePixDTO("celular", "celular", 1L, 1L, "celular", "celular", "celular",
                "aleatorio", "celular", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
        verify(this.chavePixValidator).checkChaveAleatoria((String) any());
        verify(this.chavePixValidator).checkChaveValorGenerica((String) any());
        verify(this.chavePixValidator).checkNumeroAgencia((Long) any());
        verify(this.chavePixValidator).checkNumeroConta((Long) any());
        verify(this.chavePixValidator).checkTipoChave((String) any());
        verify(this.chavePixValidator).checkTipoConta((String) any());
        verify(this.chavePixValidator).checkTipoPessoa((String) any());
    }
}

