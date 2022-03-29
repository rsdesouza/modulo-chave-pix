package br.com.itau.modulochavepix.service;

import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ChavePixService {

    public String salvarChave(ChavePix any)throws BusinessException;

    Optional<ChavePix> getByIdChave(String idChave);

    void deleteChavePix(String idChave) ;

    ChavePix inativaChavePix(String idChave);

    void deleteChavePix(ChavePix chavePix) ;

    ChavePix atualizaChavePix(ChavePix chavePix)  throws BusinessException;

    Page<ChavePix> busca(ChavePix filter, Pageable pageRequest);
}
