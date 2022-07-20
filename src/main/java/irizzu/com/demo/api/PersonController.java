package irizzu.com.demo.api;

import irizzu.com.demo.model.Person;
import irizzu.com.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    public void addPerson(Person person){
        personService.addPerson(person);
    }

}
