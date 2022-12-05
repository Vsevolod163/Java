package Homeworks.homework2;

public class homework_2 {

    public static void main(String[] params) {
        int[] array = new int[] { 33, 21, 12, 19, 124, 300, 15, 270 };
        System.out.println(arrayToString(array));
        array = mergeSort(array);
        System.out.println(arrayToString(array));
    }

    public static int[] mergeSort(int[] array) {
        int[] temp_var;
        int[] current1 = array;
        int[] current2 = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(current1, i, current1, i + size, current2, i, size);
            }

            temp_var = current1;
            current1 = current2;
            current2 = temp_var;

            size = size * 2;

            System.out.println(arrayToString(current1));
        }
        return current1;
    }

    private static void merge(int[] src1, int start1, int[] src2, int start2, int[] dest,
            int destStart, int size) {
        int index1 = start1;
        int index2 = start2;

        int src1End = Math.min(start1 + size, src1.length);
        int src2End = Math.min(start2 + size, src2.length);

        if (start1 + size > src1.length) {
            for (int i = start1; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - start1 + src2End - start2;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
