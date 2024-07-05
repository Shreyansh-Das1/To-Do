package org.personal.todo2;

import org.springframework.data.repository.CrudRepository;


public interface taskrepo extends CrudRepository<task, Long> {
}
