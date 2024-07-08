package org.personal.todo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Todo2Application{
    @Autowired private final taskrepo taskrep;
    @Autowired
    public Todo2Application(taskrepo taskrep) {
        this.taskrep = taskrep;
    }

    public static void main(String[] args) {
        SpringApplication.run(Todo2Application.class, args);
    }
}
