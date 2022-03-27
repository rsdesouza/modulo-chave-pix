package br.com.itau.modulochavepix.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CHAVE_PIX")
public class ChavePix {
    @Id
    @Column (name = "ID_CHAVE")
    private String idChave;
    @Column (name = "TIPO_CHAVE")
    private String tipoChave;
    @Column (name = "CHAVE_VALOR")
    private String chaveValor;
    @Column (name = "CADASTRADA_EM")
    private LocalDateTime cadastradaEm;
    @Column (name = "INATIVA_EM")
    private LocalDateTime inativaEm;
    @Column (name = "TIPO_CONTA")
    private String tipoConta;
    @Column (name = "TIPO_PESSOA")
    private String tipoPessoa;
    @Column (name = "NUM_AGENCIA")
    private Long numAgencia;
    @Column (name = "NUM_CONTA")
    private Long numConta;
    @Column (name = "NOME_CORRENTISTA")
    private String nomeCorrentista;
    @Column (name = "SOBRENOME_CORRENTISTA")
    private String sobrenomeCorrentista;

}
