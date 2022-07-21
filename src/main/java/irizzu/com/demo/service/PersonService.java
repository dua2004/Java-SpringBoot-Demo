package irizzu.com.demo.service;

import irizzu.com.demo.dao.PersonDAO;
import irizzu.com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO _PersonDAO;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO _PersonDAO) {
        this._PersonDAO = _PersonDAO;
    }

    public int addPerson(Person person){
        return _PersonDAO.insertPerson(person);
    }
    
    public List<Person> getAllPerson(){
        return _PersonDAO.getAllPerson();
    }
    public Person findPersonById(UUID id){
        return _PersonDAO.findPersonById(id).orElse(null);
    }
    public List<Person> findPersonByName(String name){
        return _PersonDAO.findPersonByName(name);
    }
    public boolean deletePersonById(UUID id){
        return _PersonDAO.deletePersonById(id);
    }
    public boolean updatePersonById(UUID id,Person person){
        return _PersonDAO.updatePersonById(id,person);
    }
}
