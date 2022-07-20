package irizzu.com.demo.service;

import irizzu.com.demo.dao.PersonDAO;
import irizzu.com.demo.model.Person;
import irizzu.com.demo.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

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
    
    public ResponseObject getAllPerson(){
        var response = new ResponseObject();
        var persons = _PersonDAO.getAllPerson();
        if(persons !=null)
        {
            response.response_data = persons;
            response.status_code = 200;
            response.error_internal = "";
            response.message_to_show = "";
        }
        else{
            response.response_data = null;
            response.status_code = 400;
            response.error_internal = "";
            response.message_to_show = "Persons not found";
        }
        return response;
    }
    public ResponseObject findPersonById(UUID id){
        var response = new ResponseObject();
        var person = _PersonDAO.findPersonById(id).orElse(null);
        if(person !=null)
        {
            response.response_data = person;
            response.status_code = 200;
            response.error_internal = "";
            response.message_to_show = "";
        }
        else{
            response.response_data = null;
            response.status_code = 400;
            response.error_internal = "";
            response.message_to_show = "Person not found";
        }
        return response;
    }
    public ResponseObject findPersonByName(String name){
        var response = new ResponseObject();
        var person = _PersonDAO.findPersonByname(name).orElse(null);
        if(person !=null)
        {
            response.response_data = person;
            response.status_code = 200;
            response.error_internal = "";
            response.message_to_show = "";
        }
        else{
            response.response_data = null;
            response.status_code = 400;
            response.error_internal = "";
            response.message_to_show = "Person not found";
        }
        return response;
    }

}
