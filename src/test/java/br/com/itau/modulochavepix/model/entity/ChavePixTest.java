package br.com.itau.modulochavepix.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ChavePixTest {
    @Test
    void testBuilder() {
        // TODO: This test is incomplete.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ChavePixBuilder.cadastradaEm
        //     ChavePixBuilder.chaveValor
        //     ChavePixBuilder.idChave
        //     ChavePixBuilder.inativaEm
        //     ChavePixBuilder.nomeCorrentista
        //     ChavePixBuilder.numAgencia
        //     ChavePixBuilder.numConta
        //     ChavePixBuilder.sobrenomeCorrentista
        //     ChavePixBuilder.tipoChave
        //     ChavePixBuilder.tipoConta
        //     ChavePixBuilder.tipoPessoa

        ChavePix.builder();
    }

    @Test
    void testCanEqual() {
        assertFalse((new ChavePix()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ChavePix chavePix = new ChavePix();

        ChavePix chavePix1 = new ChavePix();
        chavePix1.setCadastradaEm(LocalDateTime.of(3, 3, 3, 3, 1));
        chavePix1.setChaveValor("Chave Valor");
        chavePix1.setIdChave("Id Chave");
        chavePix1.setInativaEm(LocalDateTime.of(3, 3, 3, 3, 1));
        chavePix1.setNomeCorrentista("Nome Correntista");
        chavePix1.setNumAgencia(3L);
        chavePix1.setNumConta(3L);
        chavePix1.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix1.setTipoChave("Tipo Chave");
        chavePix1.setTipoConta("Tipo Conta");
        chavePix1.setTipoPessoa("Tipo Pessoa");
        assertTrue(chavePix.canEqual(chavePix1));
    }

    @Test
    void testConstructor() {
        ChavePix actualChavePix = new ChavePix();
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePix.setCadastradaEm(ofResult);
        actualChavePix.setChaveValor("Chave Valor");
        actualChavePix.setIdChave("Id Chave");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePix.setInativaEm(ofResult1);
        actualChavePix.setNomeCorrentista("Nome Correntista");
        actualChavePix.setNumAgencia(1L);
        actualChavePix.setNumConta(1L);
        actualChavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        actualChavePix.setTipoChave("Tipo Chave");
        actualChavePix.setTipoConta("Tipo Conta");
        actualChavePix.setTipoPessoa("Tipo Pessoa");
        assertSame(ofResult, actualChavePix.getCadastradaEm());
        assertEquals("Chave Valor", actualChavePix.getChaveValor());
        assertEquals("Id Chave", actualChavePix.getIdChave());
        assertSame(ofResult1, actualChavePix.getInativaEm());
        assertEquals("Nome Correntista", actualChavePix.getNomeCorrentista());
        assertEquals(1L, actualChavePix.getNumAgencia().longValue());
        assertEquals(1L, actualChavePix.getNumConta().longValue());
        assertEquals("Sobrenome Correntista", actualChavePix.getSobrenomeCorrentista());
        assertEquals("Tipo Chave", actualChavePix.getTipoChave());
        assertEquals("Tipo Conta", actualChavePix.getTipoConta());
        assertEquals("Tipo Pessoa", actualChavePix.getTipoPessoa());
    }

    @Test
    void testConstructor2() {
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        ChavePix actualChavePix = new ChavePix("Id Chave", "Tipo Chave", "Chave Valor", cadastradaEm,
                LocalDateTime.of(1, 1, 1, 1, 1), "Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista",
                "Sobrenome Correntista");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePix.setCadastradaEm(ofResult);
        actualChavePix.setChaveValor("Chave Valor");
        actualChavePix.setIdChave("Id Chave");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePix.setInativaEm(ofResult1);
        actualChavePix.setNomeCorrentista("Nome Correntista");
        actualChavePix.setNumAgencia(1L);
        actualChavePix.setNumConta(1L);
        actualChavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        actualChavePix.setTipoChave("Tipo Chave");
        actualChavePix.setTipoConta("Tipo Conta");
        actualChavePix.setTipoPessoa("Tipo Pessoa");
        assertSame(ofResult, actualChavePix.getCadastradaEm());
        assertEquals("Chave Valor", actualChavePix.getChaveValor());
        assertEquals("Id Chave", actualChavePix.getIdChave());
        assertSame(ofResult1, actualChavePix.getInativaEm());
        assertEquals("Nome Correntista", actualChavePix.getNomeCorrentista());
        assertEquals(1L, actualChavePix.getNumAgencia().longValue());
        assertEquals(1L, actualChavePix.getNumConta().longValue());
        assertEquals("Sobrenome Correntista", actualChavePix.getSobrenomeCorrentista());
        assertEquals("Tipo Chave", actualChavePix.getTipoChave());
        assertEquals("Tipo Conta", actualChavePix.getTipoConta());
        assertEquals("Tipo Pessoa", actualChavePix.getTipoPessoa());
    }

    @Test
    void testEquals() {
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
        assertNotEquals(chavePix, null);
    }

    @Test
    void testEquals2() {
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
        assertNotEquals(chavePix, "Different type to ChavePix");
    }

    @Test
    void testEquals3() {
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
        assertEquals(chavePix, chavePix);
        int expectedHashCodeResult = chavePix.hashCode();
        assertEquals(expectedHashCodeResult, chavePix.hashCode());
    }

    @Test
    void testEquals4() {
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
        assertEquals(chavePix, chavePix1);
        int expectedHashCodeResult = chavePix.hashCode();
        assertEquals(expectedHashCodeResult, chavePix1.hashCode());
    }

    @Test
    void testEquals5() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(3, 1, 1, 1, 1));
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals6() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals7() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Id Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals8() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals9() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Tipo Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals10() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals11() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(3, 1, 1, 1, 1));
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals12() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals13() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Id Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals14() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals15() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(3L);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals16() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals17() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(3L);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals18() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals19() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista("Id Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals20() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals21() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix.setTipoChave("Id Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals22() {
        ChavePix chavePix = new ChavePix();
        chavePix.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setChaveValor("Chave Valor");
        chavePix.setIdChave("Id Chave");
        chavePix.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix.setNomeCorrentista("Nome Correntista");
        chavePix.setNumAgencia(1L);
        chavePix.setNumConta(1L);
        chavePix.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix.setTipoChave(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals23() {
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
        chavePix.setTipoConta("Id Chave");
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals24() {
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
        chavePix.setTipoConta(null);
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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals25() {
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
        chavePix.setTipoPessoa("Id Chave");

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
        assertNotEquals(chavePix, chavePix1);
    }

    @Test
    void testEquals26() {
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
        chavePix.setTipoPessoa(null);

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
        assertNotEquals(chavePix, chavePix1);
    }
}

