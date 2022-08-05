package com.kevin.blair.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.Exception;
import java.util.List;
import java.util.Optional;

import com.kevin.blair.repositories.PersonRepository;
import com.kevin.blair.entities.Person;
import com.kevin.blair.entities.PagedPeople;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PersonController {

    // Property to hold our repository
    public PersonRepository People;

    @Autowired
    PersonService service;

    // Constructor that receives the repository via dependency injection
    public PersonController(PersonRepository people){
        this.People = people;
    }

    // Get to /people that returns list of people
    @GetMapping("/people")
    public PagedPeople getPeople(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "3") Integer size,
      @RequestParam(defaultValue = "id") String sortBy){
        PagedPeople people = service.getPeople(page, size, sortBy);
        return people; // Returns all people!
    }

    // Get to /people/:id that returns a single person
    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable Long id) throws Exception{
        Optional<Person> person = People.findById(id);

        if(person.isPresent()) {
            return person.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }

    // Post to /people, takes in request body which must be of type Person
    @PostMapping("/people")
    public List<Person> createPerson(@RequestBody Person newPerson){
        People.save(newPerson); //creates new person
        return People.findAll(); // returns all people
    }

    // put to /people/:id, takes in the body and url param id
    @PutMapping("/people/{id}")
    public List<Person> updatePerson(@RequestBody Person updatedPerson, @PathVariable Long id){
        // search for the person by id, map over the person, alter them, then save
        People.findById(id)
            .map(person -> {
                person.setName(updatedPerson.getName());
                person.setAge(updatedPerson.getAge());
                return People.save(person); // save and return edits
            });

        return People.findAll(); // return all people
    }

    // delete request to /people/:id, deletes person based on id param
    @DeleteMapping("/people/{id}")
    public List<Person> deletePerson(@PathVariable Long id){
        People.deleteById(id);
        return People.findAll();
    }

    // delete request to /people/:id, deletes person based on id param
    @DeleteMapping("/people")
    public String deleteAllPeople(){
        People.deleteAll();
        return "{ message: `All People were deleted successfully!` }";
    }
}
