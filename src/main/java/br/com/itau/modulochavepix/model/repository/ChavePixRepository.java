package br.com.itau.modulochavepix.model.repository;

import br.com.itau.modulochavepix.model.entity.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ChavePixRepository extends JpaRepository<ChavePix, String> {

    boolean existsByChaveValor(String chaveValor);

    @Query("SELECT count(u.idChave) FROM ChavePix u WHERE u.numConta = :numConta")
    Optional<Integer> getAmountOfChavePix(@Param("numConta") Long numConta);


}
