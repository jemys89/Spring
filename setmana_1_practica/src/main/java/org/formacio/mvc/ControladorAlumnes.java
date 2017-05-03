package org.formacio.mvc;

import org.formacio.component.ServeiAlumnat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ControladorAlumnes {

	@Autowired
	private ServeiAlumnat alumnatService;

	@RequestMapping(path = "/alumnes")
	@ResponseBody
	public int mostrarAlumnes() {
		return alumnatService.alumnatRegistrat();
	}
	
}
