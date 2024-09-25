package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
