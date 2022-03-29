package br.com.itau.modulochavepix.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.model.repository.ChavePixRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChavePixServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ChavePixServiceImplTest {
    @MockBean
    private ChavePixRepository chavePixRepository;

    @Autowired
    private ChavePixServiceImpl chavePixServiceImpl;

    @Test
    void testSalvarChave() {
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
        when(this.chavePixRepository.existsByChaveValor((String) any())).thenReturn(true);
        when(this.chavePixRepository.save((ChavePix) any())).thenReturn(chavePix);
        when(this.chavePixRepository.getAmountOfChavePix((Long) any())).thenReturn(Optional.of(42));

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
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.salvarChave(chavePix1));
        verify(this.chavePixRepository, atLeast(1)).existsByChaveValor((String) any());
        verify(this.chavePixRepository).getAmountOfChavePix((Long) any());
    }

    @Test
    void testGetByIdChave() {
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
        Optional<ChavePix> ofResult = Optional.of(chavePix);
        when(this.chavePixRepository.findById((String) any())).thenReturn(ofResult);
        Optional<ChavePix> actualByIdChave = this.chavePixServiceImpl.getByIdChave("Id Chave");
        assertSame(ofResult, actualByIdChave);
        assertTrue(actualByIdChave.isPresent());
        verify(this.chavePixRepository).findById((String) any());
    }

    @Test
    void testGetByIdChave2() {
        when(this.chavePixRepository.findById((String) any())).thenThrow(new BusinessException("foo"));
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.getByIdChave("Id Chave"));
        verify(this.chavePixRepository).findById((String) any());
    }

    @Test
    void testDeleteChavePix() {
        doNothing().when(this.chavePixRepository).delete((ChavePix) any());

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
        this.chavePixServiceImpl.deleteChavePix(chavePix);
        verify(this.chavePixRepository).delete((ChavePix) any());
        assertEquals("Tipo Pessoa", chavePix.getTipoPessoa());
        assertEquals("01:01", chavePix.getCadastradaEm().toLocalTime().toString());
        assertEquals("Tipo Conta", chavePix.getTipoConta());
        assertEquals("Tipo Chave", chavePix.getTipoChave());
        assertEquals("Sobrenome Correntista", chavePix.getSobrenomeCorrentista());
        assertEquals(1L, chavePix.getNumConta().longValue());
        assertEquals(1L, chavePix.getNumAgencia().longValue());
        assertEquals("Nome Correntista", chavePix.getNomeCorrentista());
        assertEquals("Id Chave", chavePix.getIdChave());
        assertEquals("01:01", chavePix.getInativaEm().toLocalTime().toString());
        assertEquals("Chave Valor", chavePix.getChaveValor());
    }

    @Test
    void testDeleteChavePix2() {
        doNothing().when(this.chavePixRepository).deleteById((String) any());
        this.chavePixServiceImpl.deleteChavePix("Id Chave");
        verify(this.chavePixRepository).deleteById((String) any());
    }

    @Test
    void testDeleteChavePix3() {
        doNothing().when(this.chavePixRepository).deleteById((String) any());
        assertThrows(IllegalArgumentException.class, () -> this.chavePixServiceImpl.deleteChavePix((String) null));
    }

    @Test
    void testDeleteChavePix4() {
        doThrow(new BusinessException("foo")).when(this.chavePixRepository).deleteById((String) any());
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.deleteChavePix("Id Chave"));
        verify(this.chavePixRepository).deleteById((String) any());
    }

    @Test
    void testInativaChavePix() {
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
        Optional<ChavePix> ofResult = Optional.of(chavePix);
        when(this.chavePixRepository.findById((String) any())).thenReturn(ofResult);
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.inativaChavePix("Id Chave"));
        verify(this.chavePixRepository).findById((String) any());
    }

    @Test
    void testInativaChavePix2() {
        ChavePix chavePix = mock(ChavePix.class);
        when(chavePix.getInativaEm()).thenReturn(null);
        doNothing().when(chavePix).setCadastradaEm((LocalDateTime) any());
        doNothing().when(chavePix).setChaveValor((String) any());
        doNothing().when(chavePix).setIdChave((String) any());
        doNothing().when(chavePix).setInativaEm((LocalDateTime) any());
        doNothing().when(chavePix).setNomeCorrentista((String) any());
        doNothing().when(chavePix).setNumAgencia((Long) any());
        doNothing().when(chavePix).setNumConta((Long) any());
        doNothing().when(chavePix).setSobrenomeCorrentista((String) any());
        doNothing().when(chavePix).setTipoChave((String) any());
        doNothing().when(chavePix).setTipoConta((String) any());
        doNothing().when(chavePix).setTipoPessoa((String) any());
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
        Optional<ChavePix> ofResult = Optional.of(chavePix);

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
        when(this.chavePixRepository.saveAndFlush((ChavePix) any())).thenReturn(chavePix1);
        when(this.chavePixRepository.findById((String) any())).thenReturn(ofResult);
        this.chavePixServiceImpl.inativaChavePix("Id Chave");
        verify(this.chavePixRepository).saveAndFlush((ChavePix) any());
        verify(this.chavePixRepository).findById((String) any());
        verify(chavePix).getInativaEm();
        verify(chavePix).setCadastradaEm((LocalDateTime) any());
        verify(chavePix).setChaveValor((String) any());
        verify(chavePix).setIdChave((String) any());
        verify(chavePix, atLeast(1)).setInativaEm((LocalDateTime) any());
        verify(chavePix).setNomeCorrentista((String) any());
        verify(chavePix).setNumAgencia((Long) any());
        verify(chavePix).setNumConta((Long) any());
        verify(chavePix).setSobrenomeCorrentista((String) any());
        verify(chavePix).setTipoChave((String) any());
        verify(chavePix).setTipoConta((String) any());
        verify(chavePix).setTipoPessoa((String) any());
    }

    @Test
    void testInativaChavePix3() {
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
        when(this.chavePixRepository.saveAndFlush((ChavePix) any())).thenReturn(chavePix);
        when(this.chavePixRepository.findById((String) any())).thenReturn(Optional.empty());
        ChavePix chavePix1 = mock(ChavePix.class);
        when(chavePix1.getInativaEm()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(chavePix1).setCadastradaEm((LocalDateTime) any());
        doNothing().when(chavePix1).setChaveValor((String) any());
        doNothing().when(chavePix1).setIdChave((String) any());
        doNothing().when(chavePix1).setInativaEm((LocalDateTime) any());
        doNothing().when(chavePix1).setNomeCorrentista((String) any());
        doNothing().when(chavePix1).setNumAgencia((Long) any());
        doNothing().when(chavePix1).setNumConta((Long) any());
        doNothing().when(chavePix1).setSobrenomeCorrentista((String) any());
        doNothing().when(chavePix1).setTipoChave((String) any());
        doNothing().when(chavePix1).setTipoConta((String) any());
        doNothing().when(chavePix1).setTipoPessoa((String) any());
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
        assertThrows(IllegalArgumentException.class, () -> this.chavePixServiceImpl.inativaChavePix("Id Chave"));
        verify(this.chavePixRepository).findById((String) any());
        verify(chavePix1).setCadastradaEm((LocalDateTime) any());
        verify(chavePix1).setChaveValor((String) any());
        verify(chavePix1).setIdChave((String) any());
        verify(chavePix1).setInativaEm((LocalDateTime) any());
        verify(chavePix1).setNomeCorrentista((String) any());
        verify(chavePix1).setNumAgencia((Long) any());
        verify(chavePix1).setNumConta((Long) any());
        verify(chavePix1).setSobrenomeCorrentista((String) any());
        verify(chavePix1).setTipoChave((String) any());
        verify(chavePix1).setTipoConta((String) any());
        verify(chavePix1).setTipoPessoa((String) any());
    }

    @Test
    void testAtualizaChavePix() {
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
        Optional<ChavePix> ofResult = Optional.of(chavePix);
        when(this.chavePixRepository.findById((String) any())).thenReturn(ofResult);

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
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.atualizaChavePix(chavePix1));
        verify(this.chavePixRepository).findById((String) any());
    }

    @Test
    void testAtualizaChavePix2() {
        ChavePix chavePix = mock(ChavePix.class);
        when(chavePix.getInativaEm()).thenReturn(null);
        doNothing().when(chavePix).setCadastradaEm((LocalDateTime) any());
        doNothing().when(chavePix).setChaveValor((String) any());
        doNothing().when(chavePix).setIdChave((String) any());
        doNothing().when(chavePix).setInativaEm((LocalDateTime) any());
        doNothing().when(chavePix).setNomeCorrentista((String) any());
        doNothing().when(chavePix).setNumAgencia((Long) any());
        doNothing().when(chavePix).setNumConta((Long) any());
        doNothing().when(chavePix).setSobrenomeCorrentista((String) any());
        doNothing().when(chavePix).setTipoChave((String) any());
        doNothing().when(chavePix).setTipoConta((String) any());
        doNothing().when(chavePix).setTipoPessoa((String) any());
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
        Optional<ChavePix> ofResult = Optional.of(chavePix);

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
        when(this.chavePixRepository.saveAndFlush((ChavePix) any())).thenReturn(chavePix1);
        when(this.chavePixRepository.findById((String) any())).thenReturn(ofResult);

        ChavePix chavePix2 = new ChavePix();
        chavePix2.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix2.setChaveValor("Chave Valor");
        chavePix2.setIdChave("Id Chave");
        chavePix2.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix2.setNomeCorrentista("Nome Correntista");
        chavePix2.setNumAgencia(1L);
        chavePix2.setNumConta(1L);
        chavePix2.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix2.setTipoChave("Tipo Chave");
        chavePix2.setTipoConta("Tipo Conta");
        chavePix2.setTipoPessoa("Tipo Pessoa");
        this.chavePixServiceImpl.atualizaChavePix(chavePix2);
        verify(this.chavePixRepository).saveAndFlush((ChavePix) any());
        verify(this.chavePixRepository).findById((String) any());
        verify(chavePix).getInativaEm();
        verify(chavePix).setCadastradaEm((LocalDateTime) any());
        verify(chavePix).setChaveValor((String) any());
        verify(chavePix).setIdChave((String) any());
        verify(chavePix).setInativaEm((LocalDateTime) any());
        verify(chavePix, atLeast(1)).setNomeCorrentista((String) any());
        verify(chavePix, atLeast(1)).setNumAgencia((Long) any());
        verify(chavePix, atLeast(1)).setNumConta((Long) any());
        verify(chavePix, atLeast(1)).setSobrenomeCorrentista((String) any());
        verify(chavePix).setTipoChave((String) any());
        verify(chavePix, atLeast(1)).setTipoConta((String) any());
        verify(chavePix).setTipoPessoa((String) any());
    }

    @Test
    void testAtualizaChavePix3() {
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
        when(this.chavePixRepository.saveAndFlush((ChavePix) any())).thenReturn(chavePix);
        when(this.chavePixRepository.findById((String) any())).thenReturn(Optional.empty());
        ChavePix chavePix1 = mock(ChavePix.class);
        when(chavePix1.getInativaEm()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(chavePix1).setCadastradaEm((LocalDateTime) any());
        doNothing().when(chavePix1).setChaveValor((String) any());
        doNothing().when(chavePix1).setIdChave((String) any());
        doNothing().when(chavePix1).setInativaEm((LocalDateTime) any());
        doNothing().when(chavePix1).setNomeCorrentista((String) any());
        doNothing().when(chavePix1).setNumAgencia((Long) any());
        doNothing().when(chavePix1).setNumConta((Long) any());
        doNothing().when(chavePix1).setSobrenomeCorrentista((String) any());
        doNothing().when(chavePix1).setTipoChave((String) any());
        doNothing().when(chavePix1).setTipoConta((String) any());
        doNothing().when(chavePix1).setTipoPessoa((String) any());
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

        ChavePix chavePix2 = new ChavePix();
        chavePix2.setCadastradaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix2.setChaveValor("Chave Valor");
        chavePix2.setIdChave("Id Chave");
        chavePix2.setInativaEm(LocalDateTime.of(1, 1, 1, 1, 1));
        chavePix2.setNomeCorrentista("Nome Correntista");
        chavePix2.setNumAgencia(1L);
        chavePix2.setNumConta(1L);
        chavePix2.setSobrenomeCorrentista("Sobrenome Correntista");
        chavePix2.setTipoChave("Tipo Chave");
        chavePix2.setTipoConta("Tipo Conta");
        chavePix2.setTipoPessoa("Tipo Pessoa");
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.atualizaChavePix(chavePix2));
        verify(this.chavePixRepository).findById((String) any());
        verify(chavePix1).setCadastradaEm((LocalDateTime) any());
        verify(chavePix1).setChaveValor((String) any());
        verify(chavePix1).setIdChave((String) any());
        verify(chavePix1).setInativaEm((LocalDateTime) any());
        verify(chavePix1).setNomeCorrentista((String) any());
        verify(chavePix1).setNumAgencia((Long) any());
        verify(chavePix1).setNumConta((Long) any());
        verify(chavePix1).setSobrenomeCorrentista((String) any());
        verify(chavePix1).setTipoChave((String) any());
        verify(chavePix1).setTipoConta((String) any());
        verify(chavePix1).setTipoPessoa((String) any());
    }

    @Test
    void testBusca() {
        PageImpl<ChavePix> pageImpl = new PageImpl<>(new ArrayList<>());
        when(this.chavePixRepository.findAll((org.springframework.data.domain.Example<ChavePix>) any(),
                (org.springframework.data.domain.Pageable) any())).thenReturn(pageImpl);

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
        Page<ChavePix> actualBuscaResult = this.chavePixServiceImpl.busca(chavePix, null);
        assertSame(pageImpl, actualBuscaResult);
        assertTrue(actualBuscaResult.toList().isEmpty());
        verify(this.chavePixRepository).findAll((org.springframework.data.domain.Example<ChavePix>) any(),
                (org.springframework.data.domain.Pageable) any());
    }

    @Test
    void testBusca2() {
        when(this.chavePixRepository.findAll((org.springframework.data.domain.Example<ChavePix>) any(),
                (org.springframework.data.domain.Pageable) any())).thenThrow(new BusinessException("foo"));

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
        assertThrows(BusinessException.class, () -> this.chavePixServiceImpl.busca(chavePix, null));
        verify(this.chavePixRepository).findAll((org.springframework.data.domain.Example<ChavePix>) any(),
                (org.springframework.data.domain.Pageable) any());
    }
}

