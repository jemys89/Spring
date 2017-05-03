package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ServeiAlumnat {

	@Autowired
	RepositoriAlumnes bbdd;
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {

		if (alumne != null) {
			bbdd.altaAlumne(id, alumne);
			return true;
		} else {
			return false;
		}

	}

	
	@PostConstruct
	private void insetarAlumnes() {

		bbdd.altaAlumne(1, "Antonia");
		bbdd.altaAlumne(2, "Joan");

	}
	
	public int alumnatRegistrat(){
		return bbdd.llistaAlumnes().size();
	}

	
}
