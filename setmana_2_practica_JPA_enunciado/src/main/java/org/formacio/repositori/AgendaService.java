package org.formacio.repositori;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

//	private Map<String, Persona> bbdd = new LinkedHashMap<>();
	
	@Autowired
	PersonaRepository personaRepository;
	
	
	@Autowired
	GrupoService grupoService;
	
	//@PostConstruct
	public void init() {
		grupoService.create("uno");
		personaRepository.save( new Persona("ant","Antoni","971-555123",grupoService.getGrupo("1")));
		personaRepository.save( new Persona("joa","Joana","971-555555" , grupoService.getGrupo("1")));
		personaRepository.save( new Persona("lin","Lina","971-555888",grupoService.getGrupo("1")));
	}
	
	public void inserta (String id, String nom, String telefon, String grupo) {
		if(grupoService.existe(grupo) == false){
			grupoService.create(grupo);
		}
		personaRepository.save(new Persona(id,nom, telefon, grupoService.getGrupo(grupo)));
		
		
		
	}
	
	public Persona recupera (String id) {
		return personaRepository.findOne(id);
	}
	
	public Long nombreContactes() {
		return personaRepository.count();
	}
	
	
	public String obtenerListado(){
		List<String> listado = new ArrayList<String>();
		for(Persona persona : personaRepository.findAll()){
			listado.add(persona.getNom());
			
		}return String.join(" ", listado);
	}
	
	public void deleteAll(){
		personaRepository.deleteAll();
	}
	
	public String listarNombreGrupo(String grupo){
		List<String> listaPersonas = new ArrayList<String>();
		for(Persona persona :  personaRepository.findByGrupoNombre(grupo)){
			listaPersonas.add(persona.getNom());
		}		
		return String.join(" ", listaPersonas);
	}
	
	public void actualizar(String id, String nom, String telefon, String grupo){
		Persona persona = personaRepository.findByClau(id);
		if(persona == null){
			this.inserta(id, nom, telefon, grupo);
		}else{
			persona.setClau(id);
			persona.setTelefon(telefon);
			persona.setNom(nom);
			
			if(grupoService.existe(grupo) == false){
				grupoService.create(grupo);
				persona.setGrupo(grupoService.getGrupo(grupo));
			}
			personaRepository.save(persona);
			
		}
		
	}
	
	public String listadoGrupos(){
		List<String> listaGrupos = new ArrayList<String>();
		for(Grupo grupo: grupoService.getGrupos()){
			listaGrupos.add(grupo.getNombre());
		}
		return String.join(" ", listaGrupos);
	}
	
	
	
}
