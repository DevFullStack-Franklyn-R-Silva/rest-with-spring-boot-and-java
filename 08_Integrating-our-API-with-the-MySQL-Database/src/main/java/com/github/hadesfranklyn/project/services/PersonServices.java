package com.github.hadesfranklyn.project.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.project.exceptions.ResourceNotFoundException;
import com.github.hadesfranklyn.project.model.Person;
import com.github.hadesfranklyn.project.repositories.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	// get one
	public Person findById(Long id) {
		logger.info("Finding one person!");

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

	// get all
	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public Person create(Person person) {
		logger.info("Creating one person!");

		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
