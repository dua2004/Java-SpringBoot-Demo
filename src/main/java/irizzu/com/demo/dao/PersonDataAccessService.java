package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPerson() {
        return List.of(new Person(UUID.randomUUID(),"from postgres DB"));
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return null;
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        return false;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return false;
    }
}
