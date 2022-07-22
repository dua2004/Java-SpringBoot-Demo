package irizzu.com.demo.dao;

import irizzu.com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertPerson(UUID id, Person person) {

        return jdbcTemplate.update("INSERT INTO PERSON (id, name) VALUES(?,?)",
                new Object[] { UUID.randomUUID(), person.getName().replace("'","") });
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
        return jdbcTemplate.query("SELECT id, name FROM person WHERE name like '%"+name.replace("'","''")+"%'",(resultSet,i)->{
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        });
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return jdbcTemplate.query("SELECT id, name FROM person WHERE id = '"+id+"';",(resultSet,i)->{
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        }).stream().findFirst();
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
