package br.com.meta.projetoapimeta.service;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import br.com.meta.projetoapimeta.model.request.GeradorQrCodeModelRequest;
import br.com.meta.projetoapimeta.model.response.GeradorQrCodeModelResponse;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QrCodeService {

	
	
	public GeradorQrCodeModelResponse lerQrCode(final MultipartFile arquivo) throws IOException, NotFoundException {
		log.info("Lendo o QR code 'Nome: {} - Tipo de Conteúdo: {}'", arquivo.getOriginalFilename(), arquivo.getContentType());
		BufferedImage bufferedImage = ImageIO.read(arquivo.getInputStream());
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binarioBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result resultado = new MultiFormatReader().decode(binarioBitmap);
		return new ObjectMapper().readValue(resultado.getText(), GeradorQrCodeModelResponse.class);
	}

	
	
	public void gerarQrCode(final GeradorQrCodeModelRequest dto, final HttpServletResponse httpServletResponse)
			throws IOException, WriterException {
		log.info("Gerar um QR code {}", dto);
		httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + dto.getTitulo().trim().replace(" ", "_") + ".png"); //".png");

		final var outputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = writer.encode(new ObjectMapper().writeValueAsString(dto), BarcodeFormat.QR_CODE, 350,
				350);
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
		outputStream.flush();
	}

}
