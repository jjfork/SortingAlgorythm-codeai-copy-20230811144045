package dataGeneration;

import com.jakubiak.runner.SortingDemo;
import com.jakubiak.scenerios.Scenario;
import com.jakubiak.scenerios.TestScenario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayGenerator {

    public TestScenario generateArray(int size, int min, int max, Scenario scenario) {

        return switch (scenario) {
            case RANDOM ->
                new TestScenario(generateRandomArray(size, min, max), Scenario.RANDOM);

            case ASCENDING ->
                new TestScenario(generateAscendingRandomArray(size, min, max), Scenario.ASCENDING);


            case DESCENDING ->
                new TestScenario(generateDescendingArray(size, min, max), Scenario.DESCENDING);

            case SORTED25 ->
                new TestScenario(generateFirst25pctSortedArray(size, min, max), Scenario.SORTED25);


            case SORTED50 ->
                new TestScenario(generateFirst50pctSortedArray(size, min, max), Scenario.SORTED50);

            default ->
                new TestScenario(generateFirst75pctSortedArray(size, min, max), Scenario.SORTED75);

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

    private int[] generateAscendingRandomArray(int size, int min, int max) {
        return ThreadLocalRandom.current().ints(min, max)   // Stream of random ints
                .limit(size)                               // Limit the stream to n values
                .boxed()                                // Convert to Stream of Integer Objects for reverse sorting
                .mapToInt(Integer::intValue)            // Map back to primitive ints
                .toArray();                             // as Array
    }


    public static int[] generateDescendingArray(int size, int min, int max) {
            return ThreadLocalRandom.current().ints(min, max)   // Stream of random ints
                    .limit(size)                               // Limit the stream to n values
                    .boxed()                                // Convert to Stream of Integer Objects for reverse sorting
                    .sorted(Collections.reverseOrder())     // Sort in reverse Order
                    .mapToInt(Integer::intValue)            // Map back to primitive ints
                    .toArray();                             // as Array
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
