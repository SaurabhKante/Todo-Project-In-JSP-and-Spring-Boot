package com.in28minutes.springboot.my_first_web_app.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    public static List<ToDo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new ToDo(++todosCount,"in28minutes", "Learn Aws", LocalDate.now().plusMonths(3),false));
        todos.add(new ToDo(++todosCount,"in28minutes", "Learn Azure", LocalDate.now().plusMonths(4),false));
        todos.add(new ToDo(++todosCount,"in28minutes", "Learn DevOps", LocalDate.now().plusMonths(5),false));
    }
    public List<ToDo> findByUsername(String username){
        Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo todo = new ToDo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }
    public void deleteTodo(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid ToDo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
