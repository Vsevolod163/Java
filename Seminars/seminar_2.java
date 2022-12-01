/*  Задайте массив из 12 элементов, заполненный случайными числами из промежутка [-9, 9].
Найдите сумму отрицательных и положительных элементов.
*/

import java.util.Scanner;

public class seminar_2 {
    public static void main(String[] args) {
        int size = input_quantity();
        create_array(size);
    }

    public static int input_quantity() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int quantity = 0;
        boolean is_correct = false;
        while (!is_correct) {
            String input = iScanner.nextLine();
            try {
                quantity = Integer.parseInt(input);
                is_correct = true;
            } catch (Exception ex) {
                System.out.print("Ошибка! Введите количество элементов массива: ");
            }
        }
        iScanner.close();
        return quantity;
    } 
    public static int[] create_array(int size) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите минимальный элемент массива: ");
        boolean is_correct = false;
        int min;
        int max;
        while (!is_correct) {
            String input = iScanner.nextLine();
            try {
                min = Integer.parseInt(input);
                is_correct = true;
            } catch (Exception ex) {
                System.out.print("Ошибка! Введите минимальный элемент: ");
            }
        }
        System.out.print("Введите максимальный элемент массива: ");
        while (!is_correct) {
            String input = iScanner.nextLine();
            try {
                max = Integer.parseInt(input);
                is_correct = true;
            } catch (Exception ex) {
                System.out.print("Ошибка! Введите максимальный элемент: ");
            }
        }
        iScanner.close();
        int[] array = new int[size];
        return array;
    }



}