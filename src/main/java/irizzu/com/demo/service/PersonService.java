package irizzu.com.demo.service;

import irizzu.com.demo.dao.PersonDAO;
import irizzu.com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDAO _PersonDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDAO _PersonDAO) {
        this._PersonDAO = _PersonDAO;
    }

    public int addPerson(Person person){
        return _PersonDAO.insertPerson(person);
    }
}
