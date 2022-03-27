package br.com.itau.modulochavepix.model.repository;

import br.com.itau.modulochavepix.model.entity.ChavePix;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChavePixRepository extends JpaRepository<ChavePix, String> {

    boolean existsByChaveValor(String chaveValor);

}
