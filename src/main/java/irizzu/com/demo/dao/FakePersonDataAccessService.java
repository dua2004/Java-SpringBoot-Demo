package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDAO {
    private static List<Person> DB= new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }
       
	@Override
	public List<Person> getAllPerson() { 
		return DB;
	}

    @Override
    public Optional<Person> findPersonByname(String name) {
        return DB.stream().filter(person -> person.getName().contains(name)).findFirst();
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
