package br.com.itau.modulochavepix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChavePixDTO {

    @NotNull(message = "O tipo de conta é obrigatório")
    private String tipoConta;

    private String tipoPessoa;
    @NotNull(message = "O número da agência é obrigatório")
    private Long numAgencia;
    @NotNull(message = "O número da conta é obrigatório")
    private Long numConta;
    @NotNull(message = "O nome do correntista é obrigatório")
    @Size(max = 30, message = "O valor do nome do correntista não pode ultrapassar 30 caracteres")
    private String nomeCorrentista;
    @Size(max = 45, message = "O valor do sobrenome do correntista não pode ultrapassar 45 caracteres")
    private String sobrenomeCorrentista;

    private String idChave;
    @NotNull(message = "O tipo de chave é obrigatório")
    private String tipoChave;
    @NotNull(message = "A chave é obrigatória")
    private String chaveValor;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime cadastradaEm;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime inativaEm;

}
