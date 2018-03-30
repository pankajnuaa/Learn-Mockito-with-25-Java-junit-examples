package com.pankaz.business;

import com.pankaz.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pankaz on 3/30/2018.
 */
public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
    }

    @Override
    public void deleteTodo(String todo) {

    }


}
