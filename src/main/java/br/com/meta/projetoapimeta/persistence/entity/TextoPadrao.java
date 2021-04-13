package br.com.meta.projetoapimeta.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.meta.projetoapimeta.persistence.entity.enums.DocumentoGerador;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_texto_padrao")
public class TextoPadrao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_seq_textopadrao", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "no_textopadrao", length = 100, nullable = false)
	private String nomeTexto;

	@Column(name = "ds_conteudo", nullable = false)
	private String conteudo;

	@Enumerated(EnumType.ORDINAL)
	private DocumentoGerador documentoGerador;

}
