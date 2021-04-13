package br.com.meta.projetoapimeta.model.response;

import java.time.LocalDate;

import br.com.meta.projetoapimeta.persistence.entity.enums.TipoSituacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentModelResponse {

	private Long id;

	private String nomeDocumento;

	private Integer numeroProcesso;

	private LocalDate dataCadastro;

	private LocalDate dataEstimadaConclusao;

	private TipoSituacao situacao;

}
