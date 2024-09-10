package br.com.julio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.julio.model.Person;
import br.com.julio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@GetMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}	
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() throws Exception {
		return services.findAll();
	}	
	
	@PostMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Person create(@RequestBody Person person) throws Exception {
		return services.create(person);
	}
	
	@PutMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Person update(@RequestBody Person person) throws Exception {
		return services.create(person);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {		
		services.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
