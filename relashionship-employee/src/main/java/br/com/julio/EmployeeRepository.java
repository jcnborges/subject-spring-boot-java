package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
