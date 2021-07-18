package br.com.meta.projetoapimeta.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeradorQrCodeModelRequest {

	@Schema(description = "Título de sua mensagem", required = true, example = "Mensagem importante")
	@NotBlank(message = "O título não pode ser vazio")
	@Size(max = 50, message = "O campo título deve conter no máximo {} caracteres")
	private String titulo;

	@Schema(description = "Mensagem que você deseja decodificar", required = true, example = "Uma mensagem aqui")
	@NotBlank(message = "O campo mensagem não pode ser vazio")
	@Size(max = 5000, message = "O campo mensagem não pode exceder a 5000 caracteres")
	private String mensagem;

	@Schema(description = "Nome da pessoa que gerou o QR code ", required = true, example = "Pedro Alves Cabral")
	@NotBlank(message = "O campo geradoPor não pode ser vazio")
	private String geradoPor;

	@Schema(description = "Nome da pessoa que irá receber o QR code gerado", required = true, example = "Fulano de tal")
	@NotBlank(message = "O campo geradoPara não pode ser vazio")
	private String geradoPara;

}
