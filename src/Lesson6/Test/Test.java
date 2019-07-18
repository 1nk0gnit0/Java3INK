package Lesson6;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void checkOneOrFourTest(){
        int [] arr = Task.creatArr();
        System.out.println(Arrays.toString(arr));
        Assert.assertTrue("False", Task.checkOneOrFour(arr));
    }

    @org.junit.Test (expected = RuntimeException.class)
    public void toArrayAfterFour(){
        int [] arr = Task.creatArr();
        System.out.println(Arrays.toString(arr));
        int[] arr2 = Task.toArrayAfterFour(arr);
        System.out.println(Arrays.toString(arr2));
        Task.toArrayAfterFour(arr);
    }

}
