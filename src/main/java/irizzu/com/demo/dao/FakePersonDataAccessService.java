package irizzu.com.demo.dao;

import com.sun.tools.jconsole.JConsoleContext;
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
    public Optional<Person> findPersonByName(String name) {
        return DB.stream().filter(person -> person.getName().contains(name)).findFirst();
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        var personToDelete = DB.stream().filter(person -> person.getId().equals(id)).findFirst();
        if(personToDelete.isPresent()) {
            return DB.remove(personToDelete);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return DB.stream().filter(x -> x.getId().equals(id)).findFirst()
                .map(p->{
                    int depersonalisation = DB.indexOf(person);
                    if(depersonalisation >= 0){
                        DB.set(depersonalisation,person);
                        return true;
                    }else{
                        return false;
                    }
                }).orElse(false);
    }
}
