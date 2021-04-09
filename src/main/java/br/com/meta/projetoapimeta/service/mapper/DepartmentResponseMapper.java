package br.com.meta.projetoapimeta.service.mapper;

import org.springframework.stereotype.Component;

import br.com.meta.projetoapimeta.model.response.DepartmentModelResponse;
import br.com.meta.projetoapimeta.persistence.entity.Department;

@Component
public class DepartmentResponseMapper implements Mapper<Department, DepartmentModelResponse> {

	@Override
	public DepartmentModelResponse map(Department input) {
		if (input == null) {
			return null;
		}

		DepartmentModelResponse response = new DepartmentModelResponse();
		response.setId(input.getId());
		response.setName(input.getName());

		return response;
	}

}
