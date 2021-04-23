package br.com.meta.projetoapimeta.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.meta.projetoapimeta.persistence.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	@Query(value = "SELECT d FROM Department d "
			+ "WHERE CONCAT(d.name, d.location.addressStreet, d.location.stateProvince, d.location.city) "
			+ "LIKE %?1% "
			+ "ORDER BY d.name")
	Page<Department> buscarPor(String keyword, Pageable pageable);

}
