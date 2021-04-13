package br.com.meta.projetoapimeta.service.mapper;

import org.springframework.stereotype.Component;

import br.com.meta.projetoapimeta.model.request.DepartmentModelInputRequest;
import br.com.meta.projetoapimeta.persistence.entity.Department;

@Component
public class DepartmentRequestMapper implements Mapper<DepartmentModelInputRequest, Department> {

	@Override
	public Department map(DepartmentModelInputRequest input) {
		if (input == null) {
			return null;
		}

		Department department = new Department();
		department.setName(input.getName());
		// department.setLocation(input.getLocation());
		return department;
	}

}
