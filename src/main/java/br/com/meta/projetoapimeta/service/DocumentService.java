package br.com.meta.projetoapimeta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.meta.projetoapimeta.model.request.DocumentModelInputRequest;
import br.com.meta.projetoapimeta.model.response.DocumentModelResponse;

public interface DocumentService {

	DocumentModelResponse criar(DocumentModelInputRequest request);

	Page<DocumentModelResponse> findAll(Pageable pageable);
}
