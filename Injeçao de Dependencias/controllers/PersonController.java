package br.com.anderson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.anderson.model.Person;
import br.com.anderson.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Anotation que realiza a instancia da classe pelo SpringBoot, conforme a anotation Service na classe PersonService.
	//Para a Autowired funcionar ela precisa da anotation Service na classe que deseja fazer isso
	@Autowired
	private PersonServices service;
	//Sem a anotation, a istancia iria ocorrer da forma tradicional
	//private PersonServices service = new PersonServices();
	
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception{			
		 return service.findById(id); 
	}
	
	


	
	
	
	

	
	
}
