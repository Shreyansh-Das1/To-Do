package org.personal.todo2;

//import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Todo2Application/* implements CommandLineRunner */{
    @Autowired private final taskrepo taskrep;

    @Autowired
    public Todo2Application(taskrepo taskrep) {
        this.taskrep = taskrep;
    }

    public static void main(String[] args) {
        SpringApplication.run(Todo2Application.class, args);
    }
   /* @Override
    public void run(String... args) throws Exception {
    }*/
}
