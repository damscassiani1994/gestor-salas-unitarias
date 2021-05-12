package co.com.gestorsalas.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.gestorsalas.entity.Sala;

public interface SalasRepository extends MongoRepository<Sala, String>{
	
	public Sala findByNombre(String nombre);

}
