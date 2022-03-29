package br.com.itau.modulochavepix.service.impl;

import br.com.itau.modulochavepix.exception.BusinessException;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import br.com.itau.modulochavepix.model.repository.ChavePixRepository;
import br.com.itau.modulochavepix.service.ChavePixService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ChavePixServiceImpl implements ChavePixService {

    private ChavePixRepository repository;

    public ChavePixServiceImpl(ChavePixRepository repository) {
        this.repository = repository;
    }

    @Override
    public String salvarChave(ChavePix chavePix){
        final int mxChavePixPorPessoaFisica = 5;
        final int mxChavePixPorPessoaJuridica = 20;

        boolean chaveValorExists = repository.existsByChaveValor(chavePix.getChaveValor());
        Optional<Integer> quantidadeChavePixPorConta = repository.getAmountOfChavePix(chavePix.getNumConta());

        if (chaveValorExists){
            if (repository.existsByChaveValor(chavePix.getChaveValor())){
                throw new BusinessException("Chave Pix já cadastrada");
            }
            if (chavePix.getTipoPessoa().equals("fisica")) {
                if (quantidadeChavePixPorConta.get() >= mxChavePixPorPessoaFisica)
                    throw new BusinessException("O limite de criação de chave Pix é de 5 chaves para o tipo de pessoa 'fisica'");
            }
            else {
                if (quantidadeChavePixPorConta.get() >= mxChavePixPorPessoaJuridica)
                    throw new BusinessException("O limite de criação de chave Pix é de 20 chaves para o tipo de pessoa 'juridica'.");
            }
        }

        repository.save(chavePix);
        return chavePix.getIdChave();

    }

    @Override
    public Optional<ChavePix> getByIdChave(String idChave) {
        return this.repository.findById(idChave);
    }

    @Override
    public void deleteChavePix(String idChave) {

        if(idChave == null){
            throw new IllegalArgumentException("O id da chave pix não poder nulo.");
        }
        this.repository.deleteById(idChave);

    }

    @Override
    public ChavePix inativaChavePix(String idChave)  {
        Optional<ChavePix> chavePix = repository.findById(idChave);

        if (chavePix.isPresent()) {
            if (chavePix.get().getInativaEm() != null) {
                throw new BusinessException("A chave pix fornecida está desabilitada!");
            }

            chavePix.get().setInativaEm(LocalDateTime.now());
            repository.saveAndFlush(chavePix.get());
            return chavePix.get();
           // this.repository.deleteById(idChave);
        }else {
            throw new IllegalArgumentException("O id da chave pix não poder nulo.");

        }

    }

    @Override
    public void deleteChavePix(ChavePix chavePix)  {
        if(chavePix == null || chavePix.getIdChave() == null){
            throw new IllegalArgumentException("O id da chave pix não poder nulo.");
        }
        this.repository.delete(chavePix);

    }

    @Override
    public ChavePix atualizaChavePix(ChavePix chavePix) {
        Optional<ChavePix> chavePixEntity = repository.findById(chavePix.getIdChave());
        if (chavePixEntity.isPresent()) {
            if (chavePixEntity.get().getInativaEm() == null) {
                chavePixEntity.get().setTipoConta(chavePix.getTipoConta());
                chavePixEntity.get().setNumAgencia(chavePix.getNumAgencia());
                chavePixEntity.get().setNumConta(chavePix.getNumConta());
                chavePixEntity.get().setNomeCorrentista(chavePix.getNomeCorrentista());
                chavePixEntity.get().setSobrenomeCorrentista(chavePix.getSobrenomeCorrentista());
                repository.saveAndFlush(chavePixEntity.get());
                return chavePixEntity.get();
            }
            else {
                throw new BusinessException("A chave pix fornecida está desabilitada!");
            }
        }
        else {
            throw new BusinessException("A chave pix fornecida não foi encontrada!");

        }

    }

    @Override
    public Page<ChavePix> busca(ChavePix filter, Pageable pageRequest) {
        Example<ChavePix> example = Example.of(filter,
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withIgnoreNullValues()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
        );
        return repository.findAll(example, pageRequest);
    }

}
