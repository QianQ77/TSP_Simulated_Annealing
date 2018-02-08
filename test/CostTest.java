import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 9/26/17.
 */
public class CostTest {

    int[] a1 = new int[]{0,1,2,3,4};
    List<Integer> list1 = Arrays.asList(0,1,2,3,4);
    int[] a2 = new int[]{0,2,4,1,3};
    List<Integer> list2 = Arrays.asList(0,2,4,1,3);

    @Test
    public void c1Test(){

        Assert.assertTrue(Cost.cost(a1, "c1") == 406);
        Assert.assertTrue(Cost.cost(list1, "c1") == 406);
    }

    @Test
    public void c2Test(){
        Assert.assertTrue(Cost.cost(a1, "c2") == 28);
        Assert.assertTrue(Cost.cost(list1, "c2") == 28);
    }

    @Test
    public void c3Test(){

        Assert.assertTrue(Cost.cost(a1, "c3") == 100);
        Assert.assertTrue(Cost.cost(a2, "c3") == 90);
        Assert.assertTrue(Cost.cost(list1, "c3") == 100);
        Assert.assertTrue(Cost.cost(list2, "c3") == 90);
    }


}
