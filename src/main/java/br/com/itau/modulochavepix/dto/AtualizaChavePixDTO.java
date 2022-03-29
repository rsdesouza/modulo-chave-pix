package br.com.itau.modulochavepix.dto;
import br.com.itau.modulochavepix.model.entity.ChavePix;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class AtualizaChavePixDTO  {

    @NotNull
    private String idChave;
    @NotNull
    private String tipoConta;
    @NotNull
    private Long numAgencia;
    @NotNull
    private Long numConta;
    @NotNull
    private String nomeCorrentista;
    private String sobrenomeCorrentista;

}
