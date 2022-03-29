package br.com.itau.modulochavepix.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.itau.modulochavepix.api.ValidaChavePix;
import br.com.itau.modulochavepix.dto.AtualizaChavePixDTO;
import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.dto.ResponseJSONMessage;
import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.service.ChavePixService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

@ContextConfiguration(classes = {ChavePixController.class})
@ExtendWith(SpringExtension.class)
class ChavePixControllerTest {
    @Autowired
    private ChavePixController chavePixController;

    @MockBean
    private ChavePixService chavePixService;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private ResponseJSONMessage responseJSONMessage;

    @MockBean
    private ValidaChavePix validaChavePix;


    @Test
    void testBuscaTipoChave2() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testInativaChavePix3() throws Exception {
        when(this.chavePixService.inativaChavePix((String) any()))
                .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/chavespix/{idChave}",
                "Id Chave");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testAtualizaChavePix() throws Exception {
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
        when(this.chavePixService.atualizaChavePix((ChavePix) any())).thenReturn(chavePix);

        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");
        String content = (new ObjectMapper()).writeValueAsString(atualizaChavePixDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/chavespix/{idChave}", "Id Chave")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idChave\":\"Id Chave\",\"tipoChave\":\"Tipo Chave\",\"chaveValor\":\"Chave Valor\",\"cadastradaEm\":[1,1,1,1,1]"
                                        + ",\"inativaEm\":[1,1,1,1,1],\"tipoConta\":\"Tipo Conta\",\"tipoPessoa\":\"Tipo Pessoa\",\"numAgencia\":1,\"numConta"
                                        + "\":1,\"nomeCorrentista\":\"Nome Correntista\",\"sobrenomeCorrentista\":\"Sobrenome Correntista\"}"));
    }

    @Test
    void testAtualizaChavePix2() throws Exception {
        when(this.chavePixService.atualizaChavePix((br.com.itau.modulochavepix.model.entity.ChavePix) any()))
                .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

        AtualizaChavePixDTO atualizaChavePixDTO = new AtualizaChavePixDTO();
        atualizaChavePixDTO.setIdChave("Id Chave");
        atualizaChavePixDTO.setNomeCorrentista("Nome Correntista");
        atualizaChavePixDTO.setNumAgencia(1L);
        atualizaChavePixDTO.setNumConta(1L);
        atualizaChavePixDTO.setSobrenomeCorrentista("Sobrenome Correntista");
        atualizaChavePixDTO.setTipoConta("Tipo Conta");
        String content = (new ObjectMapper()).writeValueAsString(atualizaChavePixDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/chavespix/{idChave}", "Id Chave")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testHandleBusinessException() {
        assertEquals(1, this.chavePixController.handleBusinessException(new BusinessException("foo")).getErrors().size());
    }

    @Test
    void testHandleBusinessException3() {
        BusinessException businessException = mock(BusinessException.class);
        when(businessException.getMessage()).thenReturn("Not all who wander are lost");
        assertEquals(1, this.chavePixController.handleBusinessException(businessException).getErrors().size());
        verify(businessException).getMessage();
    }

    @Test
    void testBuscaChavePixPorId() throws Exception {
        when(this.modelMapper.map((Object) any(), (Class<ChavePixDTO>) any())).thenReturn(new ChavePixDTO());

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
        when(this.chavePixService.getByIdChave((String) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/chavespix/{idChave}", "Id Chave");
        MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"tipoConta\":null,\"tipoPessoa\":null,\"numAgencia\":null,\"numConta\":null,\"nomeCorrentista\":null,"
                                        + "\"sobrenomeCorrentista\":null,\"idChave\":null,\"tipoChave\":null,\"chaveValor\":null,\"cadastradaEm\":null,"
                                        + "\"inativaEm\":null}"));
    }

    @Test
    void testBuscaChavePixPorId2() throws Exception {
        when(this.modelMapper.map((Object) any(), (Class<br.com.itau.modulochavepix.dto.ChavePixDTO>) any()))
                .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

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
        when(this.chavePixService.getByIdChave((String) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/chavespix/{idChave}", "Id Chave");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testBuscaChavePixPorId3() throws Exception {
        when(this.modelMapper.map((Object) any(), (Class<ChavePixDTO>) any())).thenReturn(null);

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
        when(this.chavePixService.getByIdChave((String) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/chavespix/{idChave}", "Id Chave");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testBuscaTipoChave() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chavePixController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

