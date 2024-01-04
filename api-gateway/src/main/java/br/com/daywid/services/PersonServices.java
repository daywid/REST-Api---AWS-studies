package br.com.daywid.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.daywid.models.Person;

@Service
public class PersonServices {
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person create(Person person) {

        logger.info("Creating one person");
        //database access
        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one person");
        //database access
        return person;
    }
    
    public List<Person> findAll(){
        
        logger.info("Finding all people");
        
        List<Person> persons = new ArrayList();

        for (int i = 0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        
        logger.info("Finding one person");
        
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First");
        person.setLastName("Last");
        person.setAddress("city123");
        person.setGender("gender");
        return person;
    }

    public void delete(String id) {
        
        logger.info("Deleting one person");
        //database access
    }

    private Person mockPerson(int i) {
    
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " +i);
        person.setLastName("Last name " +i);
        person.setAddress("some address from brazil "+i);
        person.setGender("male");
        return person;

    }

}
