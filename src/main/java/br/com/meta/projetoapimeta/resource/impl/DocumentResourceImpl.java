package br.com.meta.projetoapimeta.resource.impl;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.meta.projetoapimeta.model.request.DocumentModelInputRequest;
import br.com.meta.projetoapimeta.model.response.DocumentModelResponse;
import br.com.meta.projetoapimeta.resource.DocumentResourceService;
import br.com.meta.projetoapimeta.service.DocumentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/documents", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentResourceImpl implements DocumentResourceService {

	private final DocumentService documentService;

	public DocumentResourceImpl(DocumentService documentService) {
		this.documentService = documentService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public ResponseEntity<DocumentModelResponse> criar(@Valid DocumentModelInputRequest request) {
		log.info("POST /v1/documents request recebida {}", request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idDocument}")
				.buildAndExpand(request.getNomeDocumento()).toUri();
		return ResponseEntity.created(location).body(this.documentService.criar(request));
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<DocumentModelResponse>> findAll(Pageable pageable) {
		log.info("GET /v1/documents request recebida para buscar todos os documents");
		Page<DocumentModelResponse> pageDocumentModelResponse = this.documentService.findAll(pageable);
		return ResponseEntity.ok(pageDocumentModelResponse);
	}

}
