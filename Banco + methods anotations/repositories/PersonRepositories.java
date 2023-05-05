package br.com.anderson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.anderson.model.Person;


public interface PersonRepositories extends JpaRepository<Person, Long>{

}
