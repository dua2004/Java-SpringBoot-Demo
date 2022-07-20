package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);
    List<Person> getAllPerson();
    Optional<Person> findPersonByName(String name);
    Optional<Person> findPersonById(UUID id);
    boolean deletePersonById(UUID id);
    boolean updatePersonById(UUID id,Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

}
