package org.formacio.repositori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {
	
	@Autowired
	@Qualifier("grupoRepository")
	private GrupoRepository grupoRepository;
	
	
	public void deleteAll(){
		grupoRepository.deleteAll();
	}
	
	public Grupo getGrupo(String nombre){
		return grupoRepository.findByNombre(nombre);
	}
	
	public boolean existe(String nombre){
		if(grupoRepository.findByNombre(nombre) == null){
			return false;
		}
		else
			return true;
	}
	
	public void create(String nombre){
		grupoRepository.save(new Grupo(nombre));
	}
	
	public Iterable<Grupo> getGrupos(){
		return grupoRepository.findAll();
	}
	
	

}
