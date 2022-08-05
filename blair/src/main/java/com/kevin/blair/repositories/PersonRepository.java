package com.kevin.blair.repositories;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevin.blair.entities.Person;

// We create our repository, the <> typing defines the entity class acting as a schema, and type of the ID
public interface PersonRepository extends JpaRepository<Person, Long> {

    // List<Person> findByName(String name);

    // Person findById(long id);

}
