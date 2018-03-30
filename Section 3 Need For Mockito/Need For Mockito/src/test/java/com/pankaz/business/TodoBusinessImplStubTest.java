package com.pankaz.business;

import com.pankaz.data.api.TodoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;



public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodoRelatedToSpring_UsingAStub(){
        TodoService todoServiceStub = new TodoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = toDoBusiness.retriveTodosRelatedToSpring("Dummy");
        Assert.assertEquals(2,filteredTodos.size());
    }

    @Test
    public void testRetrieveTodoRelatedToSpring_UsingAStubWithZero(){
        TodoService todoServiceStub = new TodoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = toDoBusiness.retriveTodosRelatedToSpring("Dummy1");
        Assert.assertEquals(0,filteredTodos.size());
    }
}
