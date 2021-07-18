package br.com.meta.projetoapimeta.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	@Schema(description = "Name of person generating the QR code ", required = true, example = "Hardik Singh Behl")
	@NotBlank(message = "generated-by-name must not be empty")
	private String geradoPor;

	@Schema(description = "Name of person(s) for which code is being generated", required = true, example = "For Whole World")
	@NotBlank(message = "generated-for-name must not be empty")
	private String geradoPara;

}
