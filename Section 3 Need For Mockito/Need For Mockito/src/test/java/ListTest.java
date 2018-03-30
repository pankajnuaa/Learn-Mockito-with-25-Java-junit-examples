import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import static org.mockito.Mockito.*;
/**
 * Created by Pankaz on 3/30/2018.
 */
public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);

        Assert.assertEquals(2,mockList.size());
        Assert.assertEquals(2,mockList.size());
        Assert.assertEquals(2,mockList.size());
    }

    @Test
    public void letsMockListSizeMethod_ReturnMultipleValues(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(3);

        Assert.assertEquals(2,mockList.size());
        Assert.assertEquals(3,mockList.size());
        Assert.assertEquals(2,mockList.size());
    }

    @Test
    public void letsMockListGetmethod(){
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Pankaz");

        Assert.assertEquals("Pankaz",mockList.get(0));
        Assert.assertEquals(null,mockList.get(1)); // nice mock characteristic
    }

    @Test
    public void letsMockListGetmethod_WithArgumentMatcher(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("Pankaz"); //ArgumentMatcher

        Assert.assertEquals("Pankaz",mockList.get(0));
        Assert.assertEquals("Pankaz",mockList.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGetmethod_ThrowException(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));

        mockList.get(555);

    }

    @Test
    public void getListMethodWithoutMockingit(){
        List mockList = mock(List.class);


        Assert.assertEquals(null,mockList.get(0));


    }


}
