package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPerson() {
        return jdbcTemplate.query("SELECT id, name FROM person",(resultSet,i)->{
            return new Person(
                        UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        });
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
