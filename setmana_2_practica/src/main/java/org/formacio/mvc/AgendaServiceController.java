package org.formacio.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.formacio.repositori.*;

@Controller
public class AgendaServiceController {
	
	
	@Autowired
	@Qualifier("agendaService")
	private AgendaService agendaService ;
	
	@Autowired
	@Qualifier("persona")
	private Persona persona;
	
	@GetMapping("/nombre")
	@ResponseBody
	public int numeroContactos(){
		return agendaService.nombreContactes();
	}
	
	@GetMapping("/telefon")
	@ResponseBody
	public String obtenerTelefono(String id){
		
		persona = agendaService.recupera(id);
		return persona.getTelefon();
	}
	
	@ExceptionHandler()
	@GetMapping("/contacte/{id}")
	@ResponseBody
	public Persona obtenerPersona(@PathVariable String id) throws Exception{
		if(agendaService.recupera(id) == null){
			throw new Exception();
		}else{
		persona = agendaService.recupera(id);
		return persona;
	}}
	
	@PostMapping("/afegir")
	@ResponseBody
	public void añadirPersona(@RequestParam("id") String id, @RequestParam("nom") String nom, @RequestParam("telefon") String telefon ){
		
		agendaService.inserta(id, nom, telefon);
	}
	
	
}
