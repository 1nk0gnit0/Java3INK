package Lesson6.Test;

import Lesson6.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrTest {


    @Parameterized.Parameters
    public static Collection <Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 1, 1}, new int[]{1, 1}, true},
                {new int[]{0, 0, 4, 0, 0, 0, 0}, new int[]{0, 0, 0, 0}, true},
                {new int[]{2, 2, 2, 2, 2, 2, 2, 2},new int[]{}, false},
                {new int[]{4, 4, 4, 1}, new int[]{1}, true}
        });
    }
    private int[] addArr;
    private int[] outArr;
    private boolean expectedResult;

    public ArrTest(int[] arr, int[] outArr, boolean expectedResult) {
        this.addArr = arr;
        this.outArr = outArr;
        this.expectedResult = expectedResult;
    }

    @Test
    public void checkOneOrFourTest(){
        Assert.assertEquals(expectedResult, Task.checkOneOrFour(addArr));
    }

    @Test
    public void toArrayAfterFourTest(){
        Assert.assertArrayEquals(outArr,Task.toArrayAfterFour(addArr));

    }

    @Test (expected = RuntimeException.class)
    public void toArrayAfterFourTestException(){
        Task.toArrayAfterFour(addArr);
    }

}
