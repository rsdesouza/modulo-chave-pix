package br.com.itau.modulochavepix.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ChavePixDTOTest {
    @Test
    void testBuilder() {
        // TODO: This test is incomplete.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ChavePixDTOBuilder.cadastradaEm
        //     ChavePixDTOBuilder.chaveValor
        //     ChavePixDTOBuilder.idChave
        //     ChavePixDTOBuilder.inativaEm
        //     ChavePixDTOBuilder.nomeCorrentista
        //     ChavePixDTOBuilder.numAgencia
        //     ChavePixDTOBuilder.numConta
        //     ChavePixDTOBuilder.sobrenomeCorrentista
        //     ChavePixDTOBuilder.tipoChave
        //     ChavePixDTOBuilder.tipoConta
        //     ChavePixDTOBuilder.tipoPessoa

        ChavePixDTO.builder();
    }

    @Test
    void testCanEqual() {
        assertFalse((new ChavePixDTO()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        assertTrue(chavePixDTO.canEqual(new ChavePixDTO()));
    }

    @Test
    void testConstructor() {
        ChavePixDTO actualChavePixDTO = new ChavePixDTO();
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePixDTO.setCadastradaEm(ofResult);
        actualChavePixDTO.setChaveValor("Chave Valor");
        actualChavePixDTO.setIdChave("Id Chave");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePixDTO.setInativaEm(ofResult1);
        actualChavePixDTO.setNomeCorrentista("Nome Correntista");
        actualChavePixDTO.setNumAgencia(1L);
        actualChavePixDTO.setNumConta(1L);
        actualChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        actualChavePixDTO.setTipoChave("Tipo Chave");
        actualChavePixDTO.setTipoConta("Tipo Conta");
        actualChavePixDTO.setTipoPessoa("Tipo Pessoa");
        assertSame(ofResult, actualChavePixDTO.getCadastradaEm());
        assertEquals("Chave Valor", actualChavePixDTO.getChaveValor());
        assertEquals("Id Chave", actualChavePixDTO.getIdChave());
        assertSame(ofResult1, actualChavePixDTO.getInativaEm());
        assertEquals("Nome Correntista", actualChavePixDTO.getNomeCorrentista());
        assertEquals(1L, actualChavePixDTO.getNumAgencia().longValue());
        assertEquals(1L, actualChavePixDTO.getNumConta().longValue());
        assertEquals("Sobrenome Correntista", actualChavePixDTO.getSobrenomeCorrentista());
        assertEquals("Tipo Chave", actualChavePixDTO.getTipoChave());
        assertEquals("Tipo Conta", actualChavePixDTO.getTipoConta());
        assertEquals("Tipo Pessoa", actualChavePixDTO.getTipoPessoa());
    }

    @Test
    void testConstructor2() {
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        ChavePixDTO actualChavePixDTO = new ChavePixDTO("Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista",
                "Sobrenome Correntista", "Id Chave", "Tipo Chave", "Chave Valor", cadastradaEm,
                LocalDateTime.of(1, 1, 1, 1, 1));
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePixDTO.setCadastradaEm(ofResult);
        actualChavePixDTO.setChaveValor("Chave Valor");
        actualChavePixDTO.setIdChave("Id Chave");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualChavePixDTO.setInativaEm(ofResult1);
        actualChavePixDTO.setNomeCorrentista("Nome Correntista");
        actualChavePixDTO.setNumAgencia(1L);
        actualChavePixDTO.setNumConta(1L);
        actualChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        actualChavePixDTO.setTipoChave("Tipo Chave");
        actualChavePixDTO.setTipoConta("Tipo Conta");
        actualChavePixDTO.setTipoPessoa("Tipo Pessoa");
        assertSame(ofResult, actualChavePixDTO.getCadastradaEm());
        assertEquals("Chave Valor", actualChavePixDTO.getChaveValor());
        assertEquals("Id Chave", actualChavePixDTO.getIdChave());
        assertSame(ofResult1, actualChavePixDTO.getInativaEm());
        assertEquals("Nome Correntista", actualChavePixDTO.getNomeCorrentista());
        assertEquals(1L, actualChavePixDTO.getNumAgencia().longValue());
        assertEquals(1L, actualChavePixDTO.getNumConta().longValue());
        assertEquals("Sobrenome Correntista", actualChavePixDTO.getSobrenomeCorrentista());
        assertEquals("Tipo Chave", actualChavePixDTO.getTipoChave());
        assertEquals("Tipo Conta", actualChavePixDTO.getTipoConta());
        assertEquals("Tipo Pessoa", actualChavePixDTO.getTipoPessoa());
    }

    @Test
    void testEquals() {
        assertNotEquals(new ChavePixDTO(), null);
        assertNotEquals(new ChavePixDTO(), "Different type to ChavePixDTO");
    }

    @Test
    void testEquals2() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        assertEquals(chavePixDTO, chavePixDTO);
        int expectedHashCodeResult = chavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, chavePixDTO.hashCode());
    }

    @Test
    void testEquals3() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        assertEquals(chavePixDTO, chavePixDTO1);
        int expectedHashCodeResult = chavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, chavePixDTO1.hashCode());
    }

    @Test
    void testEquals4() {
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        ChavePixDTO chavePixDTO = new ChavePixDTO("Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista",
                "Sobrenome Correntista", "Id Chave", "Tipo Chave", "Chave Valor", cadastradaEm,
                LocalDateTime.of(1, 1, 1, 1, 1));
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals5() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        assertNotEquals(chavePixDTO,
                new ChavePixDTO("Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista", "Sobrenome Correntista", "Id Chave",
                        "Tipo Chave", "Chave Valor", cadastradaEm, LocalDateTime.of(1, 1, 1, 1, 1)));
    }

    @Test
    void testEquals6() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setTipoConta("Tipo Conta");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals7() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setTipoPessoa("Tipo Pessoa");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals8() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setNumConta(1L);
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals9() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setNomeCorrentista("Nome Correntista");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals10() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals11() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setIdChave("Id Chave");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals12() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setTipoChave("Tipo Chave");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals13() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setChaveValor("Chave Valor");
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals14() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals15() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();
        chavePixDTO.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        assertNotEquals(chavePixDTO, new ChavePixDTO());
    }

    @Test
    void testEquals16() {
        LocalDateTime cadastradaEm = LocalDateTime.of(1, 1, 1, 1, 1);
        ChavePixDTO chavePixDTO = new ChavePixDTO("Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista",
                "Sobrenome Correntista", "Id Chave", "Tipo Chave", "Chave Valor", cadastradaEm,
                LocalDateTime.of(1, 1, 1, 1, 1));
        LocalDateTime cadastradaEm1 = LocalDateTime.of(1, 1, 1, 1, 1);
        ChavePixDTO chavePixDTO1 = new ChavePixDTO("Tipo Conta", "Tipo Pessoa", 1L, 1L, "Nome Correntista",
                "Sobrenome Correntista", "Id Chave", "Tipo Chave", "Chave Valor", cadastradaEm1,
                LocalDateTime.of(1, 1, 1, 1, 1));

        assertEquals(chavePixDTO, chavePixDTO1);
        int expectedHashCodeResult = chavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, chavePixDTO1.hashCode());
    }

    @Test
    void testEquals17() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals18() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setTipoPessoa("Tipo Pessoa");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals19() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setNumConta(1L);
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals20() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setNomeCorrentista("Nome Correntista");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals21() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals22() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setIdChave("Id Chave");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals23() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setTipoChave("Tipo Chave");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals24() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setChaveValor("Chave Valor");
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals25() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }

    @Test
    void testEquals26() {
        ChavePixDTO chavePixDTO = new ChavePixDTO();

        ChavePixDTO chavePixDTO1 = new ChavePixDTO();
        chavePixDTO1.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        assertNotEquals(chavePixDTO, chavePixDTO1);
    }
}

