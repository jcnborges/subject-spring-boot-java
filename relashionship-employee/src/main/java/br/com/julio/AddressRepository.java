package br.com.julio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
