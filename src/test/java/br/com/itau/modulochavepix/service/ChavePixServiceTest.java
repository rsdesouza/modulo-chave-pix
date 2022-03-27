package br.com.itau.modulochavepix.service;

import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.model.repository.ChavePixRepository;
import br.com.itau.modulochavepix.service.impl.ChavePixServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ChavePixServiceTest {

    ChavePixService service;

    @MockBean
    ChavePixRepository repository;

    @BeforeEach
    public void setUp(){
        this.service = new ChavePixServiceImpl(repository);
    }

    @Test
    @DisplayName("Deve cadastrar uma chave pix")
    public void salvarChaveTest(){
        //cenario
        ChavePix chavePix = cadastrarChavePixValida();
        Mockito.when(repository.existsByChaveValor(Mockito.anyString())).thenReturn(false);

        Mockito.when(repository.save(chavePix))
                .thenReturn(ChavePix.builder()
                        .tipoConta("CORRENTE")
                        .tipoPessoa("FISICA")
                        .numConta(1234L)
                        .numAgencia(12345678L)
                        .nomeCorrentista("José")
                        .sobrenomeCorrentista("da Silva")
                        .tipoChave("CPF")
                        .idChave("9a4fa3b1-267a-48db-a184-60b1ae817896")
                        .inativaEm(null)
                        .cadastradaEm(null)
                        .chaveValor("12345678910")
                        .build());

        //execução
        ChavePix salvandoChave = service.salvarChave(chavePix);

        //verificação
        assertThat(salvandoChave.getIdChave()).isNotNull();
        assertThat(salvandoChave.getTipoConta()).isEqualTo("CORRENTE");
        assertThat(salvandoChave.getTipoPessoa()).isEqualTo("FISICA");
        assertThat(salvandoChave.getNumConta()).isEqualTo(1234L);
        assertThat(salvandoChave.getNumAgencia()).isEqualTo(12345678L);
        assertThat(salvandoChave.getNomeCorrentista()).isEqualTo("José");
        assertThat(salvandoChave.getSobrenomeCorrentista()).isEqualTo("da Silva");
        assertThat(salvandoChave.getTipoChave()).isEqualTo("CPF");
        assertThat(salvandoChave.getIdChave()).isEqualTo("9a4fa3b1-267a-48db-a184-60b1ae817896");
        assertThat(salvandoChave.getInativaEm()).isNull();
        assertThat(salvandoChave.getCadastradaEm()).isNull();

    }
    @Test
    @DisplayName("Deve lançar erro de negocio ao tentar salvar uma chave pix duplicada")
    public void naoSalvarChavePixDuplicada(){
        //cenario
        ChavePix chavePix = cadastrarChavePixValida();
        Mockito.when(repository.existsByChaveValor(Mockito.anyString())).thenReturn(true);

        //execução
        Throwable exception = Assertions.catchThrowable(() -> service.salvarChave(chavePix));

        //verificação
        assertThat(exception)
                .isInstanceOf(BusinessException.class)
                .hasMessage("Chave Pix já cadastrada");

        Mockito.verify(repository, Mockito.never()).save(chavePix);

    }

    private ChavePix cadastrarChavePixValida(){
        return ChavePix.builder()
                .tipoConta("CORRENTE")
                .tipoPessoa("FISICA")
                .numConta(1234L)
                .numAgencia(12345678L)
                .nomeCorrentista("José")
                .sobrenomeCorrentista("da Silva")
                .tipoChave("CPF")
                .idChave("9a4fa3b1-267a-48db-a184-60b1ae817896")
                .inativaEm(null)
                .cadastradaEm(null)
                .chaveValor("12345678910")
                .build();
    }
}
