
public class seminar_4 {
    public static void main(String[] args) {
        int[] array = { 1, 5, 1, 12, 0, 12, 4, 12, 4, 5, 4, 15, 15 };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] >= array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            if (i < array.length - 1) {
                if (array[i] != array[i + 1]) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i] == array[j]) {
                            count++;
                        }
                    }
                    System.out.println("Число" + " " + array[i] + " " + "повторилось" + " " + count + " " + "раз");
                }
            }
            else {
                if (i == array.length - 1){
                    for (int j = 0; j < array.length; j++) {
                        if (array[i] == array[j]) {
                            count++;
                        }
                    }
                    System.out.println("Число" + " " + array[i] + " " + "повторилось" + " " + count + " " + "раз");
                }
            }
        }
    }
}
