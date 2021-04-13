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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.meta.projetoapimeta.model.request.DepartmentModelInputRequest;
import br.com.meta.projetoapimeta.model.response.DepartmentModelResponse;
import br.com.meta.projetoapimeta.resource.DepartmentResourceService;
import br.com.meta.projetoapimeta.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentResourceImpl implements DepartmentResourceService {

	private final DepartmentService departmentService;

	public DepartmentResourceImpl(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<DepartmentModelResponse> criar(@Valid @RequestBody DepartmentModelInputRequest request) {
		log.info("POST /v1/departments request recebida {}", request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idDepartment}")
				.buildAndExpand(request.getName()).toUri();
		return ResponseEntity.created(location).body(this.departmentService.criar(request));
	}

	@Override
	@GetMapping
	public ResponseEntity<Page<DepartmentModelResponse>> findAll(Pageable pageable) {
		log.info("GET /v1/departments request recebida para buscar todos os departments");
		Page<DepartmentModelResponse> departmentModelResponse = this.departmentService.findAll(pageable);
		return ResponseEntity.ok(departmentModelResponse);
	}

}
