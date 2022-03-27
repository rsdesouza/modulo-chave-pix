package br.com.itau.modulochavepix.controller;


import br.com.itau.modulochavepix.api.errors.ApiErros;
import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.service.ChavePixService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/chavespix")
public class ChavePixController {

    private ChavePixService service;
    @Autowired
    private ModelMapper modelMapper;

    public ChavePixController(ChavePixService service, ModelMapper mapper) {
        this.modelMapper = mapper;
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChavePixDTO cadastrarChavePix(@RequestBody @Valid ChavePixDTO dto) {
        ChavePix entity = modelMapper.map(dto, ChavePix.class);
        entity = service.salvarChave(entity);
        return modelMapper.map(entity, ChavePixDTO.class);
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

}


