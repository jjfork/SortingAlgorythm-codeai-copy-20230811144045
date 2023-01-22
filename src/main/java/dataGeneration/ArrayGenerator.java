package dataGeneration;

import com.jakubiak.runner.SortingDemo;
import com.jakubiak.scenerios.Scenario;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    public SortingDemo.TestScenario generateArray(int size, int min, int max, Scenario scenario) {

        return switch (scenario) {
            case RANDOM ->
                new SortingDemo.TestScenario(generateRandomArray(size, min, max), Scenario.RANDOM);
//
//            case ASCENDING:
//                System.out.println("Fridays are better.");
//
//
//            case DESCENDING:
//                System.out.println("Weekends are best.");
//                break;
//
            case SORTED25 ->
                new SortingDemo.TestScenario(generateFirst25pctSortedArray(size, min, max), Scenario.SORTED25);


            case SORTED50 ->
                new SortingDemo.TestScenario(generateFirst50pctSortedArray(size, min, max), Scenario.SORTED50);

            default ->
                new SortingDemo.TestScenario(generateFirst75pctSortedArray(size, min, max), Scenario.SORTED75);

        };
    }



    private int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        return array;
    }

//    private int[] generateAscendingRandomArray(int size, int min, int max) {
//
//    }
//
//    private int[] generateDescendingRandomArray(int size, int min, int max) {
//
//    }

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
