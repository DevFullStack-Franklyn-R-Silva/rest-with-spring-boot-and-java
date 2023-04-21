package com.github.hadesfranklyn.project.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.project.data.vo.v1.PersonVO;
import com.github.hadesfranklyn.project.data.vo.v2.PersonVOV2;
import com.github.hadesfranklyn.project.exceptions.ResourceNotFoundException;
import com.github.hadesfranklyn.project.mapper.DozerMapper;
import com.github.hadesfranklyn.project.mapper.custom.PersonMapper;
import com.github.hadesfranklyn.project.model.Person;
import com.github.hadesfranklyn.project.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper mapper;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	// get one
	public PersonVO findById(Long id) {
		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	// get all
	public List<PersonVO> findAll() {
		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	// post
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one person with V2!");
		var entity = mapper.convertVoToEntity(person);

		var vo = mapper.convertEntityToVo( repository.save(entity));
		return vo;
	}

	//put
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	//delete
	public void delete(Long id) {
		logger.info("Deleting one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}
}
