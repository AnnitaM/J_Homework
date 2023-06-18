/*
Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение
*/


import java.util.ArrayList;
import java.util.Collections;

public class Hw3 {
    public static void main(String[] args) {
        ArrayList<Integer> array = newList(10);
        System.out.println(array);
        removeEven(array);
        System.out.println(array);
        System.out.println("Минимальное значение в списке: " + Collections.min(array));
        System.out.println("Максимальное значение в списке: " + Collections.max(array));
        System.out.println("Cреднее значение в списке: " + getMean(array));

    }
    private static ArrayList<Integer> newList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int)(Math.random()*100));
        }
        return list;
    }

    private static void removeEven(ArrayList<Integer> list) {
        ArrayList<Integer> evenArray = new ArrayList<>();
        for (int num : list) {
            if (num %2 == 0 )evenArray.add(num);
        }
        list.removeAll(evenArray);
    }

    private static Integer getMean (ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += list.get(i);
        }
        return sum / list.size();
    }
}

