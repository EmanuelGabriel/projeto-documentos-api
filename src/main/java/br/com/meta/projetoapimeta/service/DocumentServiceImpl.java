package br.com.meta.projetoapimeta.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.meta.projetoapimeta.model.request.DocumentModelInputRequest;
import br.com.meta.projetoapimeta.model.response.DocumentModelResponse;
import br.com.meta.projetoapimeta.persistence.entity.Document;
import br.com.meta.projetoapimeta.persistence.entity.enums.TipoSituacao;
import br.com.meta.projetoapimeta.persistence.repository.DocumentRepository;
import br.com.meta.projetoapimeta.service.exception.RegraNegocioException;
import br.com.meta.projetoapimeta.service.mapper.Mapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {

	private final DocumentRepository documentRepository;
	private final Mapper<DocumentModelInputRequest, Document> documentRequestMapper;
	private final Mapper<Document, DocumentModelResponse> documentResponseMapper;

	public DocumentServiceImpl(DocumentRepository documentRepository,
			Mapper<DocumentModelInputRequest, Document> documentRequestMapper,
			Mapper<Document, DocumentModelResponse> documentResponseMapper) {
		this.documentRepository = documentRepository;
		this.documentRequestMapper = documentRequestMapper;
		this.documentResponseMapper = documentResponseMapper;
	}

	@Override
	public DocumentModelResponse criar(DocumentModelInputRequest request) {
		log.info("Criando um Document {}", request);
		Assert.notNull(request, "Request inválida");

		Document document = this.documentRequestMapper.map(request);
		if (document.getDataEstimadaConclusao().isBefore(null)) {
			throw new RegraNegocioException("Data de conclusão não pode ser inferior a data do cadastro");
		}

		document.setDataCadastro(LocalDate.now());
		document.setSituacao(TipoSituacao.PENDENTE);

		return this.documentRepository.saveAndFlush(document)
				.map((Document input) -> this.documentResponseMapper.map(input));
	}

	@Override
	public Page<DocumentModelResponse> findAll(Pageable pageable) {
		log.info("Busca todos os documents");
		Assert.notNull(pageable, "Página inválida");
		return this.documentRepository.findAll(pageable).map(document -> this.documentResponseMapper.map(document));
	}

}
