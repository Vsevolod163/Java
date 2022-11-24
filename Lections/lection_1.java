/* 
 * 
 * 
 * test
*/

package Lections;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;


public class lection_1 {
    public static void main(String[] args) {
        int x = 5;
        double k = 3;
        x = (int) k;
        System.out.println(x);
        float e = 2.7f; // обозначение float
        double s = 5.7;
        char t = '{';
        boolean flag1 = true && false;
        boolean f2 = true ^ true;
        var ir = 123;
        var p = 12_25_17;
        int[] arr = new int[10];
        // int[] crr = new int[] {1, 5, 12, 7, 9};
        int[] crr = {1, 5, 12, 7, 9};

        int [][] ghj = new int [3][5];
        for (int i = 0; i < ghj.length; i++) {
            for (int j = 0; j < ghj[i].length; j++) {
                System.out.printf("%d ", ghj[i][j]);
            }
            System.out.println();
        }
        arr[3] = 15;
        System.out.println(crr);
        System.out.println(arr[3]);
        System.out.println("Hello, World, " + x + t);// jjjjjj
        System.out.println(Integer.toString(ir)); // Обертка

        int at = 1;
        int v = 2;
        int cs;
        if (at > v) {
            cs = at;
        } else {
            cs = v;
        }
        System.out.println(cs);

        // FileReader - для чтения
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("line 1");
            fw.append('\n');
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Ввод с терминала

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);

        Scanner iScanner2 = new Scanner(System.in);
        System.out.printf("int a: ");
        int x1 = iScanner2.nextInt();
        System.out.printf("double a: ");
        double y = iScanner2.nextDouble();
        System.out.printf("%d + %f = %f", x1, y, x1 + y); // %d - целые, %f - с плавающей точкой %c - одиночный символ, %s - строки
        {
            int b = 5;// область видимости
        }
        int b = 5;
        //"%.3f\n", pi); // вывод знаков после запятой
        iScanner.close();
        iScanner2.close();

    }
    static void sayHi() {
        System.out.println("hi");
    }
    static int sum(int ab, int bc) {
        return ab + bc;

    }
    // public static void mai(String[] args) {
    // int at = 1;
    // int v = 2;
    // int cs;
    // if (at > v) {
    //     cs = at;
    // } else {
    //     cs = v;
    // }
    // System.out.println(cs);
    // }
}



// public class lection_1 {
//     public static void main(String[] args) {
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("name: ");
//         String name = iScanner.nextLine();
//         System.out.printf("Привет, %s!", name);
//         iScanner.close();
//     }
// }

// Типы данных: 1) Ссылочные (массивы) 2) Примитивные (boolean, int, short, long и т.д.)


