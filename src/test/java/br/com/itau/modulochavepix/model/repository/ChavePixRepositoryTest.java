package br.com.itau.modulochavepix.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.itau.modulochavepix.model.entity.ChavePix;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ChavePixRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.itau.modulochavepix.model.entity"})
@DataJpaTest
class ChavePixRepositoryTest {
    @Autowired
    private ChavePixRepository chavePixRepository;

    @Test
    void testExistsByChaveValor() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix.setTipoChave("Tipo Chave");
        chavePix.setTipoConta("Tipo Conta");
        chavePix.setTipoPessoa("Tipo Pessoa");

        ChavePix chavePix1 = new ChavePix();
        chavePix1.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix1.setChaveValor("Chave Valor");
        chavePix1.setIdChave("Id Chave");
        chavePix1.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix1.setNomeCorrentista("Nome Correntista");
        chavePix1.setNumAgencia(1L);
        chavePix1.setNumConta(1L);
        chavePix1.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix1.setTipoChave("Tipo Chave");
        chavePix1.setTipoConta("Tipo Conta");
        chavePix1.setTipoPessoa("Tipo Pessoa");
        this.chavePixRepository.save(chavePix);
        this.chavePixRepository.save(chavePix1);
        assertFalse(this.chavePixRepository.existsByChaveValor("foo"));
    }

    @Test
    void testGetAmountOfChavePix() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix.setTipoChave("Tipo Chave");
        chavePix.setTipoConta("Tipo Conta");
        chavePix.setTipoPessoa("Tipo Pessoa");

        ChavePix chavePix1 = new ChavePix();
        chavePix1.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix1.setChaveValor("Chave Valor");
        chavePix1.setIdChave("Id Chave");
        chavePix1.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix1.setNomeCorrentista("Nome Correntista");
        chavePix1.setNumAgencia(1L);
        chavePix1.setNumConta(1L);
        chavePix1.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix1.setTipoChave("Tipo Chave");
        chavePix1.setTipoConta("Tipo Conta");
        chavePix1.setTipoPessoa("Tipo Pessoa");
        this.chavePixRepository.save(chavePix);
        this.chavePixRepository.save(chavePix1);
        Optional<Integer> actualAmountOfChavePix = this.chavePixRepository.getAmountOfChavePix(1L);
        assertTrue(actualAmountOfChavePix.isPresent());
        assertEquals(1, actualAmountOfChavePix.get());
    }
}

