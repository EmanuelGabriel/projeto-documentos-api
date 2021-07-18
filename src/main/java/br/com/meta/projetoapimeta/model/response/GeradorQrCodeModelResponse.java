package br.com.meta.projetoapimeta.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GeradorQrCodeModelResponse {

	@Schema(description = "Título de sua mensagem", required = true, example = "Mensagem importante")
	private String titulo;

	@Schema(description = "Mensagem que você deseja decodificar", required = true, example = "Uma mensagem aqui")
	private String mensagem;

	@Schema(description = "Name of person generating the QR code ", required = true, example = "Hardik Singh Behl")
	private String geradoPor;

	@Schema(description = "Name of person(s) for which code is being generated", required = true, example = "For Whole World")
	private String geradoPara;

}
