package org.formacio.repositori;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, String>{
	
	Persona findByClau(String clau);
	
	 List<Persona> findByGrupoNombre(String grupo);

}
