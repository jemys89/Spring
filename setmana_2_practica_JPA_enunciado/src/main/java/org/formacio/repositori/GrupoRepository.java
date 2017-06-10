package org.formacio.repositori;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("grupoRepository")
public interface GrupoRepository extends CrudRepository<Grupo, Integer>{
	
	Grupo findByNombre(String nombre);

}
