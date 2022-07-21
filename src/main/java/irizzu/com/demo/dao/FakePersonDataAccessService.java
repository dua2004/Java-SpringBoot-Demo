package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

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
    public List<Person> findPersonByName(String name) {
        return DB.stream().filter(x->x.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        Optional<Person> person = DB.stream().filter(x -> x.getId().equals(id)).findFirst();
        if(person.isEmpty()){
            return false;
        }else{
            return DB.remove(person.get());
        }
    }

    @Override
    public boolean updatePersonById(UUID id, Person update) {
        Optional<Person> personObjectToDelete= DB.stream().filter(x -> x.getId().equals(id)).findFirst();
        return personObjectToDelete.map(p->{
            int indexPersonUpdate = DB.indexOf(p);
            if(indexPersonUpdate >= 0 ){
                DB.set(indexPersonUpdate,new Person(id,update.getName()));
                return true;
            }else{
                return false;
            }

        }).orElse(false);
    }
}
