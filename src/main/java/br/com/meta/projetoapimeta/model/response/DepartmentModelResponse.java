package br.com.meta.projetoapimeta.model.response;

import br.com.meta.projetoapimeta.persistence.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModelResponse {

	private Long id;
	private String name;
	private String location;

	public DepartmentModelResponse(Department department) {
		this.id = department.getId();
		this.name = department.getName();
		this.location = department.getLocation().getAddressStreet();
	}
}
