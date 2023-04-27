package br.com.anderson.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.anderson.model.Person;


//A anotation Service do SpringBoot permite a injeção em run time dessa classe em outras, sem instanciar. O SringBoot irá cuidar da instanciação.
@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		//Loger imprime no "console"
		logger.info("Finding one person!"); 
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Anderson");
		person.setLasttName("Martins");
		person.setAddress("Foz do Iguaçu - Parana - Brasil");
		person.setGender("Male");
		return person;
	}

}
