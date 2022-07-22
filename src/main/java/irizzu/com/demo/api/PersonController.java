package irizzu.com.demo.api;

import irizzu.com.demo.model.Person;
import irizzu.com.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


import javax.validation.*;
import javax.validation.constraints.NotNull;
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
    public int addPerson(@Valid @NotNull @RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){

        return ResponseEntity.ok(personService.getAllPerson());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(personService.findPersonById(id));
    }
    @GetMapping(path = "/getPersonByName/{name}")
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name){
        return ResponseEntity.ok(personService.findPersonByName(name));
    }
    @DeleteMapping(path = "/{id}")
    public boolean deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }
    @PutMapping(path = "/{id}")
    public boolean updatePersonById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Person person){
        return personService.updatePersonById(id,person);
    }
}
