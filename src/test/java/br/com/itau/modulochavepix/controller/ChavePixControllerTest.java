package br.com.itau.modulochavepix.controller;

import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.service.ChavePixService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = ChavePixController.class)
@AutoConfigureMockMvc
public class ChavePixControllerTest {

    static String URL_CHAVE_PIX_API = "/api/chavespix";

    @Autowired
    MockMvc mvc;

    @MockBean
    ChavePixService service;

    @Test
    @DisplayName("Deve cadastrar uma Chave Pix com sucesso")
    public void cadastrarChavePix() throws Exception{
        ChavePixDTO dto = cadastrarNovaChavePix();

        BDDMockito.given(service.salvarChave(Mockito.any(ChavePix.class)))
                .willReturn(ChavePix.builder()
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

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders

                .post(URL_CHAVE_PIX_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("tipoConta").value(dto.getTipoConta()))
                .andExpect(MockMvcResultMatchers.jsonPath("tipoPessoa").value(dto.getTipoPessoa()))
                .andExpect(MockMvcResultMatchers.jsonPath("numAgencia").value(dto.getNumAgencia()))
                .andExpect(MockMvcResultMatchers.jsonPath("numConta").value(dto.getNumConta()))
                .andExpect(MockMvcResultMatchers.jsonPath("nomeCorrentista").value(dto.getNomeCorrentista()))
                .andExpect(MockMvcResultMatchers.jsonPath("sobrenomeCorrentista").value(dto.getSobrenomeCorrentista()))
                .andExpect(MockMvcResultMatchers.jsonPath("tipoChave").value(dto.getTipoChave()))
                .andExpect(MockMvcResultMatchers.jsonPath("chaveValor").value(dto.getChaveValor()))
                .andExpect(MockMvcResultMatchers.jsonPath("idChave").value(dto.getIdChave()))
                .andExpect(MockMvcResultMatchers.jsonPath("cadastradaEm").value(dto.getCadastradaEm()))
                .andExpect(MockMvcResultMatchers.jsonPath("inativaEm").value(dto.getInativaEm()));
    }

    @Test
    @DisplayName("Deve lançar erro de validação quando não houver dados suficientes para cadastrar a Chave Pix.")
    public void cadastrarChavePixComCamposNull() throws Exception{
        String json = new ObjectMapper().writeValueAsString(new ChavePixDTO());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders

                .post(URL_CHAVE_PIX_API)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect( status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("errors", hasSize(6)))
                .andReturn();


    }

    @Test
    @DisplayName("Deve lançar erro de validação se valor já existe cadastrado.")
    public void cadastrarChavePixDuplicada() throws Exception{
        ChavePixDTO dto = cadastrarNovaChavePix();
        String json = new ObjectMapper().writeValueAsString(dto);
        String msgErro = "Chave Pix já cadastrada";

        BDDMockito.given(service.salvarChave(Mockito.any(ChavePix.class)))
                .willThrow(new BusinessException(msgErro));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders

                .post(URL_CHAVE_PIX_API)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect( status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("errors", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("errors[0]").value(msgErro));


    }

    @Test
    @DisplayName("Limite de chaves cadastrada para pessoa Fisica é 5.")
    public void cadastrarChavePixMax5PessoaFisica(){

    }
    @Test
    @DisplayName("Limite de chaves cadastrada para pessoa Juridica é 20.")
    public void cadastrarChavePixMax20PessoaJuridica(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo celular não possuir o código pais.")
    public void cadastrarChavePixCelularSemCodigo(){

    }

    @Test
    @DisplayName("(Deve lançar erro de validação quando tipo celular não iniciar com o símbolo “+”.")
    public void cadastrarChavePixCelularSemSimbolo(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo celular não ter nove digitos e numérico.")
    public void cadastrarChavePixCelularNumeroInvalido(){

    }
    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave e-mail não conter o símbolo “@”.")
    public void cadastrarChavePixEmailSemArroba(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave e-mail não conter valores alfanuméricos.")
    public void cadastrarChavePixEmailSemValoresAlfanumericos(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave e-mail estourar o maximo de 77 caracteres.")
    public void cadastrarChavePixEmailAcima77Caracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CPF for inválido.")
    public void cadastrarChavePixCpfInvalido(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CPF utrapassar 11 dígitos.")
    public void cadastrarChavePixCpfAcima11Digitos(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CPF não conter números.")
    public void cadastrarChavePixCpfComOutrosCaracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CNPJ for inválido.")
    public void cadastrarChavePixCnpjInvalido(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CNPJ utrapassar 14 dígitos.")
    public void cadastrarChavePixCnpjAcima14Digitos(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave CNPJ não conter números.")
    public void cadastrarChavePixCnpjComOutrosCaracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando tipo de chave aleatorio utrapassar 36 caracteres alfanuméricos..")
    public void cadastrarChavePixAleatorioInvalida(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando o campo tipo de conta for NULO.")
    public void cadastrarChavePixTipoContaNull(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo tipo de conta não for CORRENTE OU POUPANÇA.")
    public void cadastrarChavePixTipoContaInvalido(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo tipo de conta utrapassar 10 caracteres.")
    public void cadastrarChavePixTipoContaAcima10Caracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo agencia não contém números.")
    public void cadastrarChavePixAgenciaSemNaoContemNumero(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da agencia for NULO.")
    public void cadastrarChavePixAgenciaNull(){

    }
    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da agencia utrapassar 4 digitos.")
    public void cadastrarChavePixAgenciaAcima4Caracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da agencia não conter números.")
    public void cadastrarChavePixAgenciaComOutrosCaracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da conta for NULO.")
    public void cadastrarChavePixContaNull(){

    }
    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da conta  utrapassar 8 digitos.")
    public void cadastrarChavePixContaAcima4Caracteres(){

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando  o campo número da conta  não conter números.")
    public void cadastrarChavePixContaComOutrosCaracteres(){

    }




/*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChavePixDTO cadastrarChavePix(@Validated @RequestBody ChavePixDTO chavePixDTO) throws ChavePixDuplicadaException {
        return chavePixService.cadastrar(chavePixDTO);
    }

    @PutMapping("/{id})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ChavePixDTO atualizaChavePix(@RequestBody ChavePixDTO chavePixDTO) throws ChavePixNaoEncontradaException {
        return chavePixService.atualizar(chavePixDTO);
    }

    @PutMapping("/{id}")
    public ChavePixDTO inativaChavePix(@RequestParam UUID id) throws ChavePixInativaException, ChavePixNaoEncontradaException {
        return chavePixService.delete(id);
    }

    @GetMapping("/buscaPelaChave")
    @ResponseStatus(HttpStatus.OK)
    public ChavePixDTO buscarPelaChave(@RequestParam String chave) throws ChavePixNaoEncontradaException {
        return chavePixService.buscaPelaChave(chave);
    }

    @GetMapping("/buscaPelaChave")
    @ResponseStatus(HttpStatus.OK)
    public ChavePixDTO buscaPeloId(@RequestParam String chave) throws ChavePixNaoEncontradaException {
        return chavePixService.buscaPelaChave(chave);
    }

    @GetMapping("/buscaPorTipoChave")
    public List<ChavePixDTO> findByTypeKey(@RequestParam String tipoChave){
        return chavePixService.buscaPeloTipoChave(tipoChave);
    }

    @GetMapping("/buscaPorAgenciaConta")
    public List<ChavePixDTO> findByHolderName(@RequestParam String nomeCorrentista) {
        return chavePixService.buscaPeloNomeCorrentista(nomeCorrentista);
    }
*/

    private ChavePixDTO cadastrarNovaChavePix() {
        ChavePixDTO dto = ChavePixDTO.builder()
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
        return dto;
    }
}
