package br.com.itau.modulochavepix.model.repository;

import br.com.itau.modulochavepix.model.entity.ChavePix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class ChavePixRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ChavePixRepository repository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir uma chave pix na base com a chave valor informado")
    public void retornarVerdadeiroQuandoChavePixExistir(){
        //cenario
        String chaveValor = "123456";
        ChavePix chavePix = ChavePix.builder()
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
                .chaveValor("123456")
                .build();
        entityManager.persist(chavePix);

        //execução
        boolean existe = repository.existsByChaveValor(chaveValor);

        //verificação
        assertThat(existe).isTrue();

    }
}
