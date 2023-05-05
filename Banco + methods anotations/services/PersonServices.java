package br.com.anderson.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.exceptions.ResoucerNotFoundException;
import br.com.anderson.model.Person;
import br.com.anderson.repositories.PersonRepositories;



@Service
public class PersonServices {
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepositories repository;
	
	public List<Person> findAll() {		
				
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResoucerNotFoundException("No records found for this id"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLasttName(person.getLasttName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResoucerNotFoundException("No records found for this id"));
		repository.delete(entity);		
	}
	

	public Person findById(Long id) {
		//Loger imprime no "console"
		logger.info("Finding one person!");		
		return repository.findById(id)
				.orElseThrow(() -> new ResoucerNotFoundException("No records found for this id"));
	}

}
