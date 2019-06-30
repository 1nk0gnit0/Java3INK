package Lesson1.FruitBox;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box;

    public Box(T[] o) {
        box = new ArrayList<>();
        for (T e: o) {
            addFruit(e);
        }
    }

    public void addFruit(T o) {
        box.add(o);
    }

    public double getWeight() {
        if (box.isEmpty()) return 0;
        else return box.get(0).getWeight() * getCount();
    }

    public boolean compare(Box<?> o) {
        return Math.abs(getWeight() - o.getWeight()) < 0.01;
    }

    public int getCount() {
        return box.size();
    }

    public void moveFruit (Box<? super T> o){
        if(!box.isEmpty()) for (T e : box) o.addFruit(e);
        box.clear();
    }


}

class BoxApp {
    public static void main(String[] args) {

        Box<Apple> fa = new Box<>(new Apple[]{new Apple(), new Apple() ,new Apple() ,new Apple(), new Apple(), new Apple()});
        Box<Orange> fo = new Box<>(new Orange[]{new Orange(), new Orange() ,new Orange() ,new Orange()});

        System.out.println("Коробка 1. Количество яблок - " + fa.getCount() + ". Общий вес: " + fa.getWeight());
        System.out.println("Коробка 2. Количество апельсин - " + fo.getCount() + ". Общий вес: " + fo.getWeight());

        if (fa.compare(fo)) System.out.println("Веса коробок 1 и 2 равны");
        else System.out.println("Веса коробок 1 и 2 не равны");
        System.out.println();

        Box<Apple> fa1 = new Box<>(new Apple[]{new Apple(), new Apple(), new Apple(), new Apple()});
        System.out.println("Добавляем коробку 3. Количество яблок - " + fa1.getCount() + ". Общий вес: " + fa1.getWeight());

        System.out.println("Пересыпаем фрукты из коробки 1 в коробку 3");
        fa.moveFruit(fa1);
        System.out.println("Результат:\n" +
                "   Коробка 1. Количество яблок - " + fa.getCount() + ". Общий вес: " + fa.getWeight() +
                "\n   Коробка 3. Количество яблок - " + fa1.getCount() + ". Общий вес: " + fa1.getWeight());



    }
}



