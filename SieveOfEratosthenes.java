package SieveOfEratosthenes;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String... args) {
        int[] array = initializeArray();
        array = findPrimesInArray(array);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static int[] initializeArray() {
        int[] array = new int[500];
        for (int i = 0; i < 500; i++) {
            array[i] = i + 2;
        }
        return array;
    }

    public static int[] findPrimesInArray(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < Math.sqrt(array[array.length - 1]); i++) {
            int element = array[i];
            if (element == -1)
                continue;

            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] % array[i] == 0) {
                    array[j] = -1;
                }
            }
        }

        Arrays.sort(array);
        int lastMarked = 0;
        int ctr = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == -1)
                lastMarked = i;
            else {
                ctr++;
            }
        }

        int[] primes = new int[ctr];
        primes = Arrays.copyOfRange(array, lastMarked + 1, array.length - 1);
        return primes;
    }

}
