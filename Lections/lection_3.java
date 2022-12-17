package Lections;

import java.util.ArrayList;
import java.util.List;

public class lection_3 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 9 };
        int[] b = new int[3];
        System.arraycopy(a, 0, b, 0, a.length);

        for (int i : a) {
            System.out.println(i);
        }

        for (int j : b) {
            System.out.println(j);
        }
        a = AddItem(a, 2);
        a = AddItem(a, 5);
        PrintArray(a);
        System.out.println();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2809);
        for (Object o : list) {
            System.out.println(o);
        }
        int test = list.get(0); // возвращает эл по позиции
        System.out.println(test);
        // list.remove(0); // удаляет эл
        list.set(0, 12); // присваивает значение по индексу
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println();
        list.clear(); // удаляет все элементы
        // List<String> list2 = List.of("12", "15");
        List<String> list2 = new ArrayList<String>();
        list2.add("5");
        System.out.println(list2);
        System.out.println(list2.get(0));

        System.out.println(list2);

    }

    static int[] AddItem(int[] array, int item) {
        int length = array.length;
        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    }

    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
