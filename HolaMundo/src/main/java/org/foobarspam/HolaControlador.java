package org.foobarspam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class HolaControlador {
	
	@RequestMapping(path="/")
	@ResponseBody
	 public String saludar(){
		 return "¡Hola Mundo!";
	 }
}
