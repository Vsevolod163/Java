package Homeworks.homework5;

public class homework_5 {

    public static void main(String[] args) {

        int num = 5;
        int result = (num * (num + 1)) / 2;
        System.out.println("Результат = " + result);
        int i = 1;
        while (i <= num) {
            String string = "";
            int k = 1;
            while (k <= i) {
                string += "* ";
                k += 1;
            }
            System.out.println(string);
            i += 1;
        }
    }

}

