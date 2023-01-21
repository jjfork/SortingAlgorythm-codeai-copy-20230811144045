package service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class ArrayGenerator {

    public int[] generateArray(int size, int min, int max, String type) {
        int[] array = new int[size];
        if ("random".equals(type)) {
            array = generateRandomArray(size, min, max);
        } else if ("first25pctSorted".equals(type)) {
            array = generateFirst25pctSortedArray(size, min, max);
        } else if ("first50pctSorted".equals(type)) {
            array = generateFirst50pctSortedArray(size, min, max);
        } else if ("first75%pctSorted".equals(type)) {
            array = generateFirst75pctSortedArray(size, min, max);
        }
        return array;
    }

    private int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    private int[] generateFirst25pctSortedArray(int size, int min, int max) {
        int[] array = generateRandomArray(size, min, max);
        Arrays.sort(array, 0, size / 4);
        return array;
    }

    private int[] generateFirst50pctSortedArray(int size, int min, int max) {
        int[] array = generateRandomArray(size, min, max);
        Arrays.sort(array, 0, size / 2);
        return array;
    }

    private int[] generateFirst75pctSortedArray(int size, int min, int max) {
        int[] array = generateRandomArray(size, min, max);
        Arrays.sort(array, 0, size / 4 * 3) ;
        return array;
    }
}
