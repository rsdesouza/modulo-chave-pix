package br.com.itau.modulochavepix.api;

import br.com.itau.modulochavepix.api.validation.ChavePixValidator;
import br.com.itau.modulochavepix.dto.ChavePixDTO;
import br.com.itau.modulochavepix.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ValidaChavePix {

    @Configuration
    static class CreatePixKeyFilterContextConfiguration {
        @Bean(name = "transactionManager")
        public ChavePixValidator chavePixValidator() {
            return new ChavePixValidator();
        }
    }

    @Qualifier("chavePixValidator")
    @Autowired
    ChavePixValidator validator;

    public void validar(ChavePixDTO dto)throws ValidationException {

        validator.checkTipoChave(dto.getTipoChave());
        validator.checkChaveValorGenerica(dto.getChaveValor());
        validator.checkTipoConta(dto.getTipoConta());
        validator.checkNumeroAgencia(dto.getNumAgencia());
        validator.checkNumeroConta(dto.getNumConta());
        validator.checkTipoPessoa(dto.getTipoPessoa());

        if (dto.getTipoChave().equals("celular"))
            validator.checkNumeroCelular(dto.getChaveValor());

        if (dto.getTipoChave().equals("email"))
            validator.checkEmail(dto.getChaveValor());

        if (dto.getTipoChave().equals("cpf"))
            validator.checkCPF(dto.getChaveValor());

        if (dto.getTipoChave().equals("cnpj"))
            validator.checkCNPJ(dto.getChaveValor());

        if (dto.getTipoChave().equals("aleatorio"))
            validator.checkChaveAleatoria(dto.getChaveValor());
    }

}

