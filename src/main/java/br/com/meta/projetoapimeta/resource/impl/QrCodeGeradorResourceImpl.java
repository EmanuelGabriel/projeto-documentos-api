package br.com.meta.projetoapimeta.resource.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import br.com.meta.projetoapimeta.model.request.GeradorQrCodeModelRequest;
import br.com.meta.projetoapimeta.model.response.GeradorQrCodeModelResponse;
import br.com.meta.projetoapimeta.service.QrCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/gerador-qrcode", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class QrCodeGeradorResourceImpl {

	private QrCodeService codeService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "Retorna um código QR .png com as informações fornecidas decodificadas dentro")
	public void qrCodeGenerationHandler(
			@Valid @RequestBody(required = true) final GeradorQrCodeModelRequest dto,
			final HttpServletResponse httpServletResponse) throws IOException, WriterException {
		log.info("POST /v1/gerador-qrcode {}", dto);
		codeService.gerarQrCode(dto, httpServletResponse);
	}

	@PutMapping(value = "/ler-qrcode", consumes = "multipart/form-data")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "retorna informações decodificadas dentro do código QR fornecido")
	public ResponseEntity<GeradorQrCodeModelResponse> ler(
			@Parameter(description = "Imagem .png do código QR gerado através deste portal") @RequestParam(value = "file", required = true) MultipartFile file)
			throws IOException, NotFoundException {
		log.info("PUT /v1/gerador-qrcode {}", file);
		return ResponseEntity.ok(codeService.lerQrCode(file));
	}

}
