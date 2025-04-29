package com.hugo.TodoList.controller;

import com.hugo.TodoList.entity.Todo;
import com.hugo.TodoList.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){ //RequestBody converte a requisição HTTP em um objeto Java/JSON
        return todoService.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id){ //PathVariable abstrai a parte do URL definida no Mapping, no caso "id", e
        //joga diretamente no parâmetro da variável, ou seja se na URL o ID for "1" no parâmetro do delete também sera "1"
        return todoService.delete(id);
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }
}
