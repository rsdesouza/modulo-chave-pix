package br.com.itau.modulochavepix.controller;


import br.com.itau.modulochavepix.api.ValidaChavePix;
import br.com.itau.modulochavepix.api.errors.ApiErros;
import br.com.itau.modulochavepix.dto.AtualizaChavePixDTO;
import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.dto.ResponseJSONMessage;
import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.exception.ValidationException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.service.ChavePixService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chavespix")
public class ChavePixController {

    private ChavePixService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ValidaChavePix validaChavePix;
    @Autowired
    private ResponseJSONMessage response;

    public ChavePixController(ChavePixService service, ModelMapper mapper) {
        this.modelMapper = mapper;
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseJSONMessage cadastrarChavePix(@RequestBody @Valid ChavePixDTO dto) throws ValidationException {
        validaChavePix.validar(dto);
        ChavePix chavePix = cadastraChavePix(dto);
        response.setId(service.salvarChave(chavePix));
        return response;

    }

    @GetMapping("/{idChave}")
    public ChavePixDTO buscaChavePixPorId (@PathVariable String idChave){
        return service
                .getByIdChave(idChave)
                .map(chavePix -> modelMapper.map(chavePix, ChavePixDTO.class))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{idChave}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ChavePix inativaChavePix(@PathVariable String idChave) throws IllegalAccessException {
        return service.inativaChavePix(idChave);

    }

    @PutMapping("/{idChave}")
    public ChavePix atualizaChavePix (@PathVariable String idChave, AtualizaChavePixDTO dto){
        ChavePix chavePix = cadastraChavePix(dto);

        return service.atualizaChavePix(chavePix);

    }

    @GetMapping
    public Page<ChavePixDTO> buscaTipoChave(ChavePixDTO dto, Pageable pageRequest){
        ChavePix filtro = modelMapper.map(dto, ChavePix.class);
        Page<ChavePix> resultado = service.busca(filtro, pageRequest);
       List<ChavePixDTO> list = resultado.getContent().stream()
                .map( entity -> modelMapper.map(entity, ChavePixDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<ChavePixDTO>(list, pageRequest, resultado.getTotalElements());

    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErros handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return new ApiErros(bindingResult);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiErros handleBusinessException(BusinessException ex) {
        return new ApiErros(ex);

    }

    private ChavePix cadastraChavePix(ChavePixDTO dto){
        ChavePix chavePix = new ChavePix();
        chavePix.setIdChave(UUID.randomUUID().toString());
        chavePix.setTipoChave(dto.getTipoChave());
        chavePix.setTipoConta(dto.getTipoConta());
        chavePix.setTipoPessoa(dto.getTipoPessoa());
        chavePix.setNumAgencia(dto.getNumAgencia());
        chavePix.setNumConta(dto.getNumConta());
        chavePix.setNomeCorrentista(dto.getNomeCorrentista());
        chavePix.setSobrenomeCorrentista(dto.getSobrenomeCorrentista());
        chavePix.setChaveValor(dto.getChaveValor());
        chavePix.setCadastradaEm(LocalDateTime.now());
        return chavePix;
    }
    private ChavePix cadastraChavePix(AtualizaChavePixDTO atualizaChavePixDTO) {
        ChavePix chavePix = new ChavePix();

        chavePix.setIdChave(atualizaChavePixDTO.getIdChave());
        chavePix.setTipoConta(atualizaChavePixDTO.getTipoConta());
        chavePix.setNumAgencia(atualizaChavePixDTO.getNumAgencia());
        chavePix.setNumConta(atualizaChavePixDTO.getNumConta());
        chavePix.setNomeCorrentista(atualizaChavePixDTO.getNomeCorrentista());
        chavePix.setSobrenomeCorrentista(atualizaChavePixDTO.getSobrenomeCorrentista());

        return chavePix;
    }

    private ChavePix cadastraChavePix(
            String tipoChave,
            Long numAgencia,
            Long numConta,
            String nomeCorrentista,
            LocalDateTime cadastradaEm,
            LocalDateTime inativaEm
    ) {
        ChavePix chavePix = new ChavePix();
        chavePix.setTipoChave(tipoChave);
        chavePix.setNumAgencia(numAgencia);
        chavePix.setNumConta(numConta);
        chavePix.setNomeCorrentista(nomeCorrentista);
        chavePix.setCadastradaEm(cadastradaEm);
        chavePix.setInativaEm(inativaEm);
        return chavePix;
    }

}


