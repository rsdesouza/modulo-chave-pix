package br.com.itau.modulochavepix.service.impl;

import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.model.repository.ChavePixRepository;
import br.com.itau.modulochavepix.service.ChavePixService;
import org.springframework.stereotype.Service;

@Service
public class ChavePixServiceImpl implements ChavePixService {

    private ChavePixRepository repository;

    public ChavePixServiceImpl(ChavePixRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChavePix salvarChave(ChavePix chavePix){
        if (repository.existsByChaveValor(chavePix.getChaveValor())){
            throw new BusinessException("Chave Pix já cadastrada");
        }
        return repository.save(chavePix);
    }
}
