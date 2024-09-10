package br.com.julio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julio.PersonRepository;
import br.com.julio.exception.ResourceNotFoundException;
import br.com.julio.model.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public Person findById(Long id) {
		logger.info("Finding one person...");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public List<Person> findAll() {
		logger.info("Find all people...");
		
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating one person...");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person...");
		
		var entity = findById(person.getId());
		
		entity.setFirstName(person.getFirstName());
		entity.setFirstName(person.getLastName());
		entity.setFirstName(person.getAddress());
		entity.setFirstName(person.getGender());
		
		return repository.save(person);
	}	
	
	public void delete(Long id) {
		logger.info("Deleting one person...");
		
		var entity = findById(id);
		
		repository.delete(entity);
	}		
}
