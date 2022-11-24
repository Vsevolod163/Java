/*+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000 */


package Homeworks.homework1;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class homework_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Homeworks/homework1/input.txt"));
        String str;
        String res = "";
        while ((str = br.readLine()) != null) {
            str = str.replace(" ", "");
            str = str.substring(2);
            res += str + " ";
        }
        br.close();
        String[] res2 = res.split(" ");
        int x1 = Integer.parseInt(res2[0]);
        int x2 = Integer.parseInt(res2[1]);
        int res_num = 0;
        double res_num2 = 0;
        String res_num3 = "";
        if (x1 != 0 && x2 >= 0) {
            res_num = (int)Math.pow(x1, x2);
            res_num3 += res_num;
        }
        if (x1 == 0 && x2 > 0){
            res_num = 0;
            res_num3 += res_num;
        }
        if (x1 == 0 && x2 < 0){
            res_num3 += "На ноль делить нельзя";
        }
        if (x2 < 0) {
            x2 = (-1) * x2;
            res_num2 = 1 / (double)Math.pow(x1, x2);
            res_num3 += res_num2;
        }
        if (x1 == 0 && x2 == 0) {
            res_num3 += "Неопределено";
        }

        try (FileWriter fw = new FileWriter("Homeworks/homework1/output.txt", false)) {
           
            fw.write("result: " + res_num3);
            fw.flush();               

                     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


