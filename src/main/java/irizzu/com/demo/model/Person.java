package irizzu.com.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class Person {
    private final UUID id;
    @NotBlank(message = "Name is mandatory")
    private final String name;

    public Person(@JsonProperty UUID id,@JsonProperty String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
