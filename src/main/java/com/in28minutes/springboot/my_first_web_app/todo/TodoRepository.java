package com.in28minutes.springboot.my_first_web_app.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo,Integer> {
    public List<ToDo> findByUsername(String username);
}
