package br.com.julio;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.julio.model.Address;
import br.com.julio.model.Department;
import br.com.julio.model.Employee;
import jakarta.transaction.Transactional;

@SpringBootTest
class MainTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	Logger logger = Logger.getLogger(MainTest.class.getName());

	@Test
	//@Transactional
	void contextLoads() {
		var department = departmentRepository.findById(1L).orElseThrow();
		departmentRepository.deleteById(department.getId());
	}

	void teste1() {
		Employee employee = new Employee();
		employee.setFirstName("Júlio César");
		employee.setLastName("Nardelli Borges");
		employee.setGender("Male");

		var newEmployee = employeeRepository.save(employee);

		Address address = new Address();
		address.setStreetName("Rua José de Alencar");
		address.setStreetNumber(111);
		address.setZipCode("80050-123");

		var newAddress = addressRepository.save(address);

		newEmployee.setAddress(newAddress);
		employeeRepository.save(newEmployee);
	}

	void teste2() {
		Department department = new Department();
		department.setName("Engenharia");

		var newDepartment = departmentRepository.save(department);

		for (int i = 1; i <= 8; i++) {
			Employee employee = new Employee();
			employee.setFirstName("FirstName " + i);
			employee.setLastName("LastName " + i);
			employee.setGender("Male");
			employee.setDepartment(newDepartment);
			employeeRepository.save(employee);
		}
	}

	void teste3() {
		var department = departmentRepository.findById(1L).orElseThrow();
		logger.info(department.getName());
		for (Employee e : department.getEmployees()) {
			logger.info(e.getFirstName());
		}
	}
}
