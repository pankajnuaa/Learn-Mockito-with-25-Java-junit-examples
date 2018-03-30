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
    }
}
