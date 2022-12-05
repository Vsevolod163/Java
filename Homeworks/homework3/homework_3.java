package Homeworks.homework3;

/*
На вход некоторому исполнителю подаётся четыре числа (a, b, c, d).

У исполнителя есть две команды
- команда 1 (к1): увеличить в с раз, а умножается на c
- команда 2 (к2): увеличить на d , к a прибавляется d
написать программу, которая выдаёт общее количество возможных преобразований a в b

a: 2 b: 7 c: 2 d: 1 -> 3
a: 3 b: 27 c: 3 d: 2 -> 6
a: 30 b: 345 c: 5 d: 6 -> 0
a: 30 b: 345 c: 2 d: 1 -> 7047
a: 22 b: 333 c: 3 d: 1 -> 467
a: 55 b: 555 c: 5 d: 2 -> 30
a: 22 b: 2022 c: 11 d: 56 -> 0
a: 22 b: 2022 c: 11 d: 10 -> 18
a: 22 b: 2022 c: 3 d: 1 -> 763827
a: 22 b: 20220 c: 3 d: 1 -> 535173226980
a: 1 b: 1111 c: 2 d: 1 -> 3990330794
a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286
 */

public class homework_3 {
    public static void main(String[] args) {
        result(22, 20220, 3, 1);
    }

    public static void result(int a, int b, int c, int d) {
        long[] array = new long[b + 1];
        long count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        if (c > d) {
            for (int i = 0; i < array.length; i++) {
                if (i == a) {
                    array[i] = 1;
                }
                if (i > a) {
                    if (i % c != 0) {
                        array[i] = array[i - d];
                    } else {
                        array[i] = array[i - d] + array[i / c];
                    }
                }
            }
        }
        if (c < d) {
            count = 0;
        } else {
            count = array[b];
        }
        System.out.println(count);
    }
}
