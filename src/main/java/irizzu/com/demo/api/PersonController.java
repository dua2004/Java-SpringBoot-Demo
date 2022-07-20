package irizzu.com.demo.api;

import irizzu.com.demo.model.Person;
import irizzu.com.demo.model.ResponseObject;
import irizzu.com.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public ResponseObject getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(path = "/{id}")
    public ResponseObject getPersonById(@PathVariable("id") UUID id){
        return personService.findPersonById(id);
    }
}
