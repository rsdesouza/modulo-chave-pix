package br.com.itau.modulochavepix.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AtualizaChavePixDTOTest {
    @Test
    void testCanEqual() {
        assertFalse((new AtualizaChavePixDTO()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(3L);
        atualizaChavePixDTO1.setNumConta(3L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertTrue(atualizaChavePixDTO.canEqual(atualizaChavePixDTO1));
    }

    @Test
    void testConstructor() {
        AtualizaChavePixDTO actualAtualizaChavePixDTO = new AtualizaChavePixDTO();
        actualAtualizaChavePixDTO.setIdChave("Id Chave");
        actualAtualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        actualAtualizaChavePixDTO.setNumAgencia(1L);
        actualAtualizaChavePixDTO.setNumConta(1L);
        actualAtualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        actualAtualizaChavePixDTO.setTipoConta("Tipo Conta");
        assertEquals("Id Chave", actualAtualizaChavePixDTO.getIdChave());
        assertEquals("Nome Correntista", actualAtualizaChavePixDTO.getNomeCorrentista());
        assertEquals(1L, actualAtualizaChavePixDTO.getNumAgencia().longValue());
        assertEquals(1L, actualAtualizaChavePixDTO.getNumConta().longValue());
        assertEquals("Sobrenome Correntista", actualAtualizaChavePixDTO.getSobrenomeCorrentista());
        assertEquals("Tipo Conta", actualAtualizaChavePixDTO.getTipoConta());
    }

    @Test
    void testEquals() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, null);
    }

    @Test
    void testEquals2() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, "Different type to AtualizaChavePixDTO");
    }

    @Test
    void testEquals3() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO.hashCode());
    }

    @Test
    void testEquals4() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO1.hashCode());
    }

    @Test
    void testEquals5() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Tipo Conta");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals6() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave(null);
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals7() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Id Chave");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals8() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista(null);
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals9() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(3L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals10() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(null);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals11() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(3L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals12() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(null);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals13() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Id Chave");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals14() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista(null);
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals15() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Id Chave");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals16() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta(null);

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertNotEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
    }

    @Test
    void testEquals17() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave(null);
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave(null);
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO1.hashCode());
    }

    @Test
    void testEquals18() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista(null);
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista(null);
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO1.hashCode());
    }

    @Test
    void testEquals19() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(null);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(null);
        atualizaChavePixDTO1.setNumConta(1L);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO1.hashCode());
    }

    @Test
    void testEquals20() {
        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(null);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");

        AtualizaChavePixDTO atualizaChavePixDTO1 = new AtualizaChavePixDTO();
        atualizaChavePixDTO1.setIdChave("Id Chave");
        atualizaChavePixDTO1.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO1.setNumAgencia(1L);
        atualizaChavePixDTO1.setNumConta(null);
        atualizaChavePixDTO1.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO1.setTipoConta("Tipo Conta");
        assertEquals(atualizaChavePixDTO, atualizaChavePixDTO1);
        int expectedHashCodeResult = atualizaChavePixDTO.hashCode();
        assertEquals(expectedHashCodeResult, atualizaChavePixDTO1.hashCode());
    }
}

