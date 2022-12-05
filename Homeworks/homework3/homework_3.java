package Homeworks.homework3;

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
