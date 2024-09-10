package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
