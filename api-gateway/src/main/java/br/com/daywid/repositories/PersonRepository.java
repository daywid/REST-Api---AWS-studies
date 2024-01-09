package br.com.daywid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.daywid.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
//allows all common database operations