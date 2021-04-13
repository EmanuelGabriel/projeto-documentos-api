package br.com.meta.projetoapimeta.persistence.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentoGerador {
	
	 DESPACHO_INDEFERIDO(1, "Despacho de Indeferimento"),
	 NOTA_TECNICA_DEFERIMENTO(2, "Nota Técnica de Deferimento"),
	 NOTA_TECNICA_INDEFERIDO(3, "Nota Técnica de Indeferimento"),
	 NOTA_TECNICA_DILIGENCIA_OU_RETIFICACAO(4, "Nota Ténica de Diligência (ou de Retificação)"),
	 MINUTA_INDEFERIMENTO_QUALIFICACAO(5, "Minuta de Indeferimento de Qualificação"),
	 MINUTA_CERTIFICADO_QUALIFICACAO_DEFERIMENTO(6, "Minuta de Certificado de Qualificação (Deferimento)"),
	 MINUTA_SENAJUS(7, "Minuta para SENAJUS");
	 
	private Integer cod;
	 private String descricao;

}
