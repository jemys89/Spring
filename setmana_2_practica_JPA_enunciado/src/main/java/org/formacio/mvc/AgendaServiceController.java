package org.formacio.mvc;


import java.util.ArrayList;
import java.util.List;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Grupo;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgendaServiceController {
	
	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(path="/nombre")
	@ResponseBody
	public String nombreContactes(){
		Long nombreContactes = agenda.nombreContactes();
		return nombreContactes.toString();		
	}
	
	@RequestMapping(path="/telefon")
	@ResponseBody
	public String recuperaTelefon(@RequestParam String id){
		return agenda.recupera(id).getTelefon();
	}
	
	
	@RequestMapping(path="/contacte/{id}")
	@ResponseBody
	public Persona recuperaContacte(@PathVariable String id){
		if(agenda.recupera(id) == null){
			throw new OperationException();
		} 	
		else
			return agenda.recupera(id);
	}
	
	@RequestMapping(path="/afegir", method=RequestMethod.POST)
	@ResponseBody
	public String afegirContacte(@RequestParam String id, @RequestParam String nom, @RequestParam String telefon, @RequestParam String grupo){
		agenda.actualizar(id, nom, telefon, grupo);
		return "ok";
	}
	@RequestMapping(path="/actualizar", method=RequestMethod.POST)
	@ResponseBody
	public String actualizarContacte(@RequestParam String id, @RequestParam String nom, @RequestParam String telefon, @RequestParam String grupo){
		
		agenda.actualizar(id,nom,telefon, grupo);
		return "ok";
		
	}
	@RequestMapping(path="/name")
	@ResponseBody
	public String recuperaNombre(@RequestParam String id){
		return agenda.recupera(id).getNom();
	}
	
	@RequestMapping(path="/listado")
	@ResponseBody
	public String recuperaNombre(){
		return agenda.obtenerListado();
		
	}
	
	@RequestMapping("/grupo")
	@ResponseBody
	public String nombreGrupo(@RequestParam String grupo){
		return agenda.listarNombreGrupo(grupo);
	}
	
	@RequestMapping("/grupos")
	@ResponseBody
	public String listarNombreGrupo(@RequestParam String grupo){
		return agenda.listadoGrupos();
	}
	


}
