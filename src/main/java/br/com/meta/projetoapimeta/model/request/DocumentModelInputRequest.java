package br.com.meta.projetoapimeta.model.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.meta.projetoapimeta.persistence.entity.enums.TipoSituacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentModelInputRequest {

	@NotBlank(message = "Nome do documento não pode ser vazio")
	private String nomeDocumento;

	@NotNull(message = "Número do processo não pode ser nulo")
	private Integer numeroProcesso;

	private LocalDate dataEstimadaConclusao;

	private TipoSituacao situacao;

}
