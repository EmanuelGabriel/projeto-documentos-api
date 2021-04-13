package br.com.meta.projetoapimeta.service.mapper;

import org.springframework.stereotype.Component;

import br.com.meta.projetoapimeta.model.request.DocumentModelInputRequest;
import br.com.meta.projetoapimeta.persistence.entity.Document;
import br.com.meta.projetoapimeta.service.exception.EntityNaoEncontradaException;

@Component
public class DocumentRequestMapper implements Mapper<DocumentModelInputRequest, Document> {

	@Override
	public Document map(DocumentModelInputRequest input) {
		if (input == null) {
			throw new EntityNaoEncontradaException("Document não encontrado");
		}

		Document document = new Document();
		document.setNomeDocumento(input.getNomeDocumento());
		document.setDataEstimadaConclusao(input.getDataEstimadaConclusao());
		document.setNumeroProcesso(input.getNumeroProcesso());
		document.setSituacao(input.getSituacao());

		return document;
	}

}
