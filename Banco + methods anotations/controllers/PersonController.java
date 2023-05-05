package br.com.anderson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.anderson.model.Person;
import br.com.anderson.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//A anotation REQUESTMAP mapeia os end points e encontra o adequado para cada requisição. Se não criarmos end points ambiguos, não teremos erro. 
	//Basicamente, a requisição é verificada e conforme os parametos passados (PathParans ou QueryParans) ou o metodo (GET, POST, PUT, DELETE) o REQUESTMAP irá encontrar o end point
	
	@Autowired
	private PersonServices service;
		
	//Parametro recebido pela URL (PathParams = / e QueryParams = ?chave=valor)
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) throws Exception{			
		 return service.findById(id); 
	}
	
	
	//Parametros recebidos pelo body (testando pelo postman)
	//o CONSUMES informa que o metodo irá receber as informações como JSON e o PRODUCES também informa que a resposa será um JSON
	//A anotation @RequestBody configura o recebimento dos dados pelo BODY (no caso, recebe os dados da pessoa e salva ela no banco)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) throws Exception{			
		return service.create(person); 
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) throws Exception{			
		return service.update(person); 
	}
	
		
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){			
		 return service.findAll(); 
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id){			
		 service.delete(id);  
	}
	
	


	
	
	
	

	
	
}
