package com.github.hadesfranklyn.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hadesfranklyn.project.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
