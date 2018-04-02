package com.pankaz.business;

import com.pankaz.data.api.TodoService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ToDoBusinessImplTest extends TestCase {

    public void testRetriveTodosRelatedToSpring() throws Exception {

        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance");

        given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(todoServiceMock);


        // when
      List<String> todoFromMock =  toDoBusiness.retriveTodosRelatedToSpring("Pankaz");

      assertEquals(todoFromMock.size(),1);


    }

    public void testDeleteTodosNotRelatedToSpring() throws Exception {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        //When
        toDoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        verify(todoServiceMock).deleteTodo("Learn to dance");
        then(todoServiceMock).should().deleteTodo("Learn to dance");

        verify(todoServiceMock,times(1)).deleteTodo("Learn to dance");
        verify(todoServiceMock,atLeast(1)).deleteTodo("Learn to dance");

        verify(todoServiceMock,never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");

    }

    public void testDeleteTodosNotRelatedToSpring_CaptureArguments()  {

        //Declare Argument captor

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Define Argument captor on specific method
        //capture the argument
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        //When
        toDoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
//        verify(todoServiceMock).deleteTodo("Learn to dance");
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        Assert.assertThat(stringArgumentCaptor.getValue(),is("Learn to dance"));


    }


    public void testDeleteTodosNotRelatedToSpring_CaptureArgumentsMultipleTimes()  {

        //Declare Argument captor

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Define Argument captor on specific method
        //capture the argument
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance","Learn to rock and roll");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        //When
        toDoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        //Then
//        verify(todoServiceMock).deleteTodo("Learn to dance");
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

        Assert.assertThat(stringArgumentCaptor.getAllValues().size(),is(2));


    }
}