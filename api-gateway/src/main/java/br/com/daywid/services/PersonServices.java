package br.com.daywid.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daywid.exceptions.ResourceNotFoundException;
import br.com.daywid.models.Person;
import br.com.daywid.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {

        logger.info("Creating one person");
        //database access
        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one person");
        //database access
        var entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records for this ID") );

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }
    
    public List<Person> findAll(){
        
        logger.info("Finding all people");
        //database access
        return repository.findAll();
    }

    public Person findById(Long id){
        
        logger.info("Finding one person");
        
        Person person = new Person();
       //database access
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records for this ID") );
    }

    public void delete(Long id) {

        logger.info("Deleting one person");

        //database access
        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records for this ID") );
        repository.delete(entity);
    }

    // private Person mockPerson(int i) {
    
    //     Person person = new Person();
    //     person.setId(counter.incrementAndGet());
    //     person.setFirstName("Person name " +i);
    //     person.setLastName("Last name " +i);
    //     person.setAddress("some address from brazil "+i);
    //     person.setGender("male");
    //     return person;

    // }

}
