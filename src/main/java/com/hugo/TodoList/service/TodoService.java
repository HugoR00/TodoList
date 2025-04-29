package com.hugo.TodoList.service;

import com.hugo.TodoList.entity.Todo;
import com.hugo.TodoList.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    private final TodoRepository todoRepository; //Injeção de dependência via construtor

    public TodoService(TodoRepository todoRepository) { //Injeção de dependência via construtor
        this.todoRepository = todoRepository;
    }

    public List<Todo> list(){
        //Filtrando primeiro por prioridade de forma descendente depois por nome de forma ascendente, colocando na var
        //sort e então dando findall dessa sort
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list(); //Depois de criar vai listar tudo como criado acima, assim você não precisa escrever toda a
        //listagem novamente, repetindo código
    }
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
}
