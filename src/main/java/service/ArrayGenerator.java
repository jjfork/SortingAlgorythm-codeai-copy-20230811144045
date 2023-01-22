package service;

import com.jakubiak.runner.SortingDemo;
import com.jakubiak.scenerios.Scenario;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    public SortingDemo.TestScenario generateArray(int size, int min, int max, String type) {
        if ("random".equals(type)) {
            return new SortingDemo.TestScenario(generateRandomArray(size, min, max), Scenario.RANDOM);
        } else if ("first25pctSorted".equals(type)) {
            return new SortingDemo.TestScenario(generateFirst25pctSortedArray(size, min, max), Scenario.SORTED25);
        } else if ("first50pctSorted".equals(type)) {
            return new SortingDemo.TestScenario(generateFirst50pctSortedArray(size, min, max), Scenario.SORTED50);
        } else if ("first75pctSorted".equals(type)) {
            return new SortingDemo.TestScenario(generateFirst75pctSortedArray(size, min, max), Scenario.SORTED75);
        }

        //przepisz na switchcase
        return new SortingDemo.TestScenario(null, null);
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
        Arrays.sort(array, 0, (size / 4)*3)  ;
        return array;
    }
}
