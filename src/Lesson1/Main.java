package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Есть массив\n" + Arrays.toString(intArray));
        System.out.println("Меняем местами первый и последний эллемент:");

        try {
            swapElements(intArray, 0, 4);
            System.out.println(Arrays.toString(intArray));
        }catch (Exception e){
            System.out.println("Неверное значение");
        }

        System.out.println("Преобразуем массив ArrayList\n" + asList(intArray));

    }

    public static <T> void swapElements(T[] o, int pos1, int pos2) {
        T t = o[pos1];
        o[pos1] = o[pos2];
        o[pos2] = t;
    }

    public static <T> ArrayList<T> asList(T[] o) {
        ArrayList<T> res = new ArrayList<>();
        if (o.length > 0) {
            for (T t : o) {
                res.add(t);
            }
        }
        return res;
    }


}
