package Lesson6;

import java.util.Arrays;

public class Task {
    public static int[] creatArr(){
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random()*10);
        }
        return arr;
    }

    public static int[] toArrayAfterFour(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == 4) return Arrays.copyOfRange(arr, i + 1, arr.length);
        }
        throw new RuntimeException();
    }

    public static boolean checkOneOrFour (int[] arr){
        for (int i : arr){
            if(i == 1 || i == 4)
                return true;
        }
        return false;
    }
}

class Main{
    public static void main(String[]args){

        int[] arr = Task.creatArr();
        System.out.println(Arrays.toString(arr));

        int[] arr2 = Task.toArrayAfterFour(arr);
        System.out.println(Arrays.toString(arr2));
    }
}