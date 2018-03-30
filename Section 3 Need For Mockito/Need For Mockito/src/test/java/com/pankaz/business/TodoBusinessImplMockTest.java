package com.pankaz.business;

import com.pankaz.data.api.TodoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Pankaz on 3/30/2018.
 */
public class TodoBusinessImplMockTest {


    @Test
    public void testRetrieveTodoRelatedToSpring_UsingAMock(){
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");


        TodoService todoServiceMock = mock(TodoService.class);//Creates mock for the todoservice
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos); //ask to return the defined list as the defined parameter is passed

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = toDoBusiness.retriveTodosRelatedToSpring("Dummy");
        Assert.assertEquals(2, filteredTodos.size());
    }
    @Test
    public void testRetrieveTodoRelatedToSpring_WithEmptyList(){
        List<String> todos = Arrays.asList();


        TodoService todoServiceMock = mock(TodoService.class);//Creates mock for the todoservice
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos); //ask to return the defined list as the defined parameter is passed

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = toDoBusiness.retriveTodosRelatedToSpring("Dummy");
        Assert.assertEquals(0,filteredTodos.size());
    }

    @Test
    public void testRetrieveTodoRelatedToSpring_using_BDD(){
        //Given

        TodoService todoServiceMock = mock(TodoService.class);//Creates mock for the todoservice

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");
//        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos); //ask to return the defined list as the defined parameter is passed
        //Alternate
        given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceMock);
        //When -SUT


        List<String> filteredTodos = toDoBusiness.retriveTodosRelatedToSpring("Dummy");
        //Then


//        Assert.assertEquals(2,filteredTodos.size());
        assertThat(filteredTodos.size(),is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_UsingBDD(){
        //Given

        TodoService todoServiceMock = mock(TodoService.class);//Creates mock for the todoservice

        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");
//        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos); //ask to return the defined list as the defined parameter is passed
        //Alternate
        given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceMock);
        //When -SUT


        toDoBusiness.deleteTodosNotRelatedToSpring("Spring");
        //Then


//        Assert.assertEquals(2,filteredTodos.size());
        verify(todoServiceMock).deleteTodo("Learn to Dance");


    }
}
