package br.com.julio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.julio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one person...");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Júlio César");
		person.setLastName("Nardelli Borges");
		person.setAddress("Cristo Rei - Curitiba - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {
		logger.info("Find all people...");
		
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("FirstName " + i);
		person.setLastName("LastName " + i);
		person.setAddress("Address " + i);
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person...");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person...");
		return person;
	}	
	
	public void delete(String id) {
		logger.info("Deleting one person...");
	}		
}
