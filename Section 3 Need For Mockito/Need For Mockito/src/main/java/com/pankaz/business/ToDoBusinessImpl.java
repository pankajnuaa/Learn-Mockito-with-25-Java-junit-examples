package com.pankaz.business;

import com.pankaz.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImpl {
    private TodoService todoService;

    public ToDoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retriveTodosRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo: todos){
            if (todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }

        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user){
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo: todos){
            if (!todo.contains("Spring")){
                todoService.deleteTodo(todo);
            }
        }


    }
}
