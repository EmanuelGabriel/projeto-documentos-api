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

	@Schema(description = "Nome da pessoa que foi gerado o QR code ", required = true, example = "Pedro Alves Cabral")
	private String geradoPor;

	@Schema(description = "Nome da pessoa que irá receber o QRCode", required = true, example = "Fulano de tal")
	private String geradoPara;

}
