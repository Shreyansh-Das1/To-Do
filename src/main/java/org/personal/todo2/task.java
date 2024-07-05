package org.personal.todo2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class task {
    public task() {}
    private String description;
    private boolean completed;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    public task(String description) {
        this.description = description;
        this.completed = false;
    }
}
